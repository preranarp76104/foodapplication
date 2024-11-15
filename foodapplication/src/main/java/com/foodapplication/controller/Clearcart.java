package com.foodapplication.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Clearcart")
public class Clearcart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the session
        HttpSession session = req.getSession();

        // Clear the cart by removing the attribute
        session.removeAttribute("cart");

        // Redirect to cart.jsp to show the cleared cart
        resp.sendRedirect("cart.jsp");
    }
}
