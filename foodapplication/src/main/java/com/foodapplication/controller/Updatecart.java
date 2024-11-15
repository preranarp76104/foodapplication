package com.foodapplication.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapplication.model.CartItem;

@WebServlet("/Updatecart")
public class Updatecart extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");

    	    if (cart == null) {
    	        cart = new HashMap<>(); // Initialize if null
    	        System.out.println("Cart initialized as new HashMap");
    	    }

    	    String midParam = req.getParameter("mid");
    	    String quantityParam = req.getParameter("quantity");

    	    // Debug output to check parameter values
    	    System.out.println("midParam: " + midParam);
    	    System.out.println("quantityParam: " + quantityParam);

    	    if (midParam != null && quantityParam != null) {
    	        try {
    	            int mid = Integer.parseInt(midParam);
    	            int quantity = Integer.parseInt(quantityParam);

    	            if (cart.containsKey(mid)) {
    	                CartItem existingItem = cart.get(mid);
    	                existingItem.setQuantity(quantity);

    	                // Update cart in session
    	                req.getSession().setAttribute("cart", cart);

    	                // Update cart in DAO
    	                cartDAOimp1 cdaoi = new cartDAOimp1();
    	                cart = cdaoi.updateItem(cart, mid, quantity);
    	                req.getSession().setAttribute("cart", cart);  // Save updated cart back to session

    	                resp.sendRedirect("cart.jsp");  // Redirect to the cart page
    	            } else {
    	                req.getRequestDispatcher("error.jsp").forward(req, resp); // Handle item not found
    	            }
    	        } catch (NumberFormatException e) {
    	            e.printStackTrace();
    	            req.getRequestDispatcher("error.jsp").forward(req, resp);  // Handle invalid input
    	        }
    	    } else {
    	        req.getRequestDispatcher("error.jsp").forward(req, resp);  // Handle missing parameters
    	    }

    }
}
