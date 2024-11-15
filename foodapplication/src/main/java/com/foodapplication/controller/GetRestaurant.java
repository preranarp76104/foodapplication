package com.foodapplication.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapplication.model.Restaurant;


@WebServlet("/GetRestaurant")
public class GetRestaurant extends HttpServlet {
private ArrayList<Restaurant> restaurantList;

@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	RestaurantDAOimp1 rdimp1=new RestaurantDAOimp1();
    restaurantList=rdimp1.getAllRestaurants();
    System.out.println("Get rest java"+restaurantList);
    req.getSession().setAttribute("restaurantList",restaurantList);
    resp.sendRedirect("Home.jsp");
	}

}
