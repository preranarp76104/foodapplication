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
import com.foodapplication.model.Menu;

@WebServlet("/cart")
public class cart extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
            req.getSession().setAttribute("cart", cart);
        }

        String midParam = req.getParameter("mid");
        String quantityParam = req.getParameter("quantity");

        try {
            if (midParam != null && quantityParam != null) {
                int mid = Integer.parseInt(midParam);
                int quantity = Integer.parseInt(quantityParam);

                MenuDAOimp1 mdaoi = new MenuDAOimp1();
                Menu m = mdaoi.fetchSpecific(mid);

                if (m != null) {
                    if (cart.containsKey(mid)) {
                        // Update the quantity if item already exists in the cart
                        CartItem existingItem = cart.get(mid);
                        existingItem.setQuantity(existingItem.getQuantity() + quantity);
                    } else {
                        // Add a new item if it does not exist in the cart
                        CartItem ci = new CartItem(mid, m.getRid(), m.getMname(), quantity, m.getPrice(), m.getRating());
                        cartDAOimp1 cdaoi=new cartDAOimp1();
                        cart=cdaoi.addItem(cart,ci);
                    }

                    req.getSession().setAttribute("cart", cart);
                } else {
                    req.setAttribute("errorMessage", "Menu item not found.");
                }
            } else {
                req.setAttribute("errorMessage", "Invalid or missing parameters.");
            }
        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "Invalid format for menu ID or quantity.");
        }

        if (req.getAttribute("errorMessage") != null) {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("cart.jsp");
        }
    }
}

