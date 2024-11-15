package com.foodapplication.controller;
	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapplication.model.Restaurant;

	public class RestaurantDAOimp1 implements RestaurantDAO {

	    private final String INSERT_QUERY = "INSERT INTO restaurant(rname, address, cusineetype, ratings,image) VALUES(?, ?, ?, ?,?)";
	    private final String FETCH_SPECIFIC_QUERY = "SELECT * FROM restaurant WHERE rid = ?";
	    private final String UPDATE_QUERY = "UPDATE restaurant SET rname = ?, address = ?, cusineetype = ?, ratings = ? image=? WHERE rid = ?";
	    private final String DELETE_QUERY = "DELETE FROM restaurant WHERE rid = ?";
	    private final String FETCH_ALL_QUERY = "SELECT * FROM restaurant";

	    private int status;
	    private String url = "jdbc:mysql://localhost:3306/project";
	    private String username = "root";
	    private String password = "root";
	    private Connection con;
	    private PreparedStatement pstmt;
	    private Statement stmt;
	    private ResultSet resultSet;

	    ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
	    private Restaurant restaurant;

	    public RestaurantDAOimp1() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, username, password);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public int addRestaurant(Restaurant r) {
	        try {
	            pstmt = con.prepareStatement(INSERT_QUERY);
	            pstmt.setString(1, r.getRname());
	            pstmt.setString(2, r.getAddress());
	            pstmt.setString(3, r.getCuisineType());
	            pstmt.setDouble(4, r.getRatings());
	            pstmt.setString(3, r.getImage());

	            status = pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return status;
	    }

	    @Override
	    public Restaurant fetchSpecific(int restaurantId) {
	        try {
	            pstmt = con.prepareStatement(FETCH_SPECIFIC_QUERY);
	            pstmt.setInt(1, restaurantId);
	            resultSet = pstmt.executeQuery();
	            if (resultSet.next()) {
	                restaurant = new Restaurant(
	                    resultSet.getInt("restaurantId"),
	                    resultSet.getString("name"),
	                    resultSet.getString("address"),
	                    resultSet.getString("cuisine"),
	                    resultSet.getDouble("rating"),
	                    resultSet.getString("image")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return restaurant;
	    }

	    @Override
	    public int updateRestaurant(Restaurant r) {
	        try {
	            pstmt = con.prepareStatement(UPDATE_QUERY);
	            pstmt.setString(1, r.getRname());
	            pstmt.setString(2, r.getAddress());
	            pstmt.setString(3, r.getCuisineType());
	            pstmt.setDouble(4, r.getRatings());
	            pstmt.setInt(5, r.getRid());
	            pstmt.setString(6, r.getImage());

	            status = pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return status;
	    }

	    @Override
	    public int deleteRestaurant(int restaurantId) {
	        try {
	            pstmt = con.prepareStatement(DELETE_QUERY);
	            pstmt.setInt(1, restaurantId);
	            status = pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return status;
	    }

	    @Override
	    public ArrayList<Restaurant> getAllRestaurants() {
	        try {
	            stmt = con.createStatement();
	            resultSet = stmt.executeQuery(FETCH_ALL_QUERY);
	            this.restaurantList = extractRestaurantsFromResultSet(resultSet);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        System.out.println("fetch all rest "+restaurantList);
	        return this.restaurantList;
	    }

	    ArrayList<Restaurant> extractRestaurantsFromResultSet(ResultSet resultSet) {
	        
	        try {
	            while (resultSet.next()) {
	                this.restaurantList.add(new Restaurant(
	                    resultSet.getInt("rid"),
	                    resultSet.getString("rname"),
	                    resultSet.getString("cusineetype"),
	                    resultSet.getString("address"),
	                    resultSet.getDouble("ratings"),
	                    resultSet.getString("image")
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        System.out.println("fetcextract res "+restaurantList);
	        return this.restaurantList;
	    }

	
	}


