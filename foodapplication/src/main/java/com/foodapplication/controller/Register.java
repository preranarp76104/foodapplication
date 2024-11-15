package com.foodapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapplication.model.User;
import com.tap.secret.Encrypt;

@WebServlet("/Register")
public class Register extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = Encrypt.encrypt(req.getParameter("username"));
        String email = Encrypt.encrypt(req.getParameter("email"));
        String password = Encrypt.encrypt(req.getParameter("password"));
        String confirmPassword = Encrypt.encrypt(req.getParameter("confirmPassword"));
        String phoneStr = req.getParameter("phone");

        
            int phone = Integer.parseInt(phoneStr); // Convert phone to int

            if (password.equals(confirmPassword)) {
                UserDAOimp1 userDao = new UserDAOimp1();
                User user = new User(username, email, password, phone);

                boolean isRegistered = userDao.registerUser(user);
                if (isRegistered) {
                    resp.sendRedirect("Login.jsp");
                } else {
                    resp.sendRedirect("registrationFailed.jsp");
                }
            } else {
                resp.sendRedirect("pwdIncorrect.jsp");
            }
       
    }
}
