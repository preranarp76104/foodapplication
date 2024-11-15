package com.foodapplication.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapplication.model.CartItem;

@WebServlet("/Deletecartitem")
public class Deletecartitem extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the "mid" parameter from the request
        String parmid = req.getParameter("mid");

        if (parmid != null && !parmid.isEmpty()) {
            try {
                int mid = Integer.parseInt(parmid);

                // Retrieve the session and the cart
                HttpSession session = req.getSession();
                Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

                if (cart != null && cart.containsKey(mid)) {
                    // Remove the item from the cart
                    cart.remove(mid);
                    // Update the cart in the session
                    session.setAttribute("cart", cart);
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid mid format: " + parmid);
            }
        }

        // Redirect to cart.jsp to show the updated cart
        resp.sendRedirect("cart.jsp");
    }
}
