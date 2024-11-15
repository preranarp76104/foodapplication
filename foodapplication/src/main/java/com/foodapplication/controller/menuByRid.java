package com.foodapplication.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapplication.model.Menu;
import com.foodapplication.model.Restaurant;

@WebServlet("/menuByRid")
public class menuByRid extends HttpServlet {
	private ArrayList<Menu> menuByRid;
	

	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rid=Integer.parseInt(req.getParameter("rid"));
		MenuDAOimp1 mimp1=new MenuDAOimp1();
		menuByRid=mimp1.getOnrid(rid);
	    System.out.println("Get menu java"+menuByRid);
	    req.getSession().setAttribute("menuByRid",menuByRid);
	    resp.sendRedirect("Menu.jsp");
		}

       
 
}
