package com.foodapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapplication.model.User;
import com.tap.secret.Encrypt;





@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=Encrypt.encrypt(req.getParameter("email"));
	String password=Encrypt.encrypt(req.getParameter("password"));
	//String encryptedEmail = Encrypt.encrypt(email);
	UserDAOimp1 udaoi=new UserDAOimp1();
	System.out.println("Once encrypted "+email);
	//System.out.println("Second encrypted "+encryptedEmail);
	User u=udaoi.fetchSpecific(email);
	if(u!=null) {
		if(u.getPassword().equals(password)) {
			HttpSession session=req.getSession();
			session.setAttribute("loggedInUser", u);
			resp.sendRedirect("GetRestaurant");
		}
	else {
		resp.sendRedirect("pwdIncorrect.jsp");
	}
}else {
	resp.sendRedirect("invaliduser.jsp");
}
}
}
