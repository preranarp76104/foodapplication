package com.foodapplication.controller;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapplication.model.Menu;

public class MenuDAOimp1 implements MenuDAO {

    private final String INSERT_QUERY = "INSERT INTO menu(rid, mname, description, price, rating,image) VALUES(?, ?, ?, ?, ?,?)";
    private final String FETCH_SPECIFIC_QUERY = "SELECT * FROM menu WHERE mid = ?";
    private final String UPDATE_QUERY = "UPDATE menu SET mname = ?, description = ?, price = ?, rating = ? image=? WHERE mid = ?";
    private final String DELETE_QUERY = "DELETE FROM menu WHERE mid = ?";
    private final String FETCH_ALL_QUERY = "SELECT * FROM menu";
    private final String FETCH_BY_RID_QUERY = "SELECT * FROM menu WHERE rid = ?";

    private int status;
    private String url = "jdbc:mysql://localhost:3306/project";
    private String username = "root";
    private String password = "root";
    private Connection con;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;

    ArrayList<Menu> menuList = new ArrayList<Menu>();

    public MenuDAOimp1() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addMenuItem(Menu menuItem) {
        try {
            pstmt = con.prepareStatement(INSERT_QUERY);
            pstmt.setInt(1, menuItem.getRid());
            pstmt.setString(2, menuItem.getMname());
            pstmt.setString(3, menuItem.getDescription());
            pstmt.setInt(4, menuItem.getPrice());
            pstmt.setDouble(5, menuItem.getRating());
            pstmt.setString(6, menuItem.getImage());

            status = pstmt.executeUpdate();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public Menu fetchSpecific(int mid) {
        Menu menu = null;
        try {
            pstmt = con.prepareStatement(FETCH_SPECIFIC_QUERY);
            pstmt.setInt(1, mid);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
            	 menu = new Menu(
                         resultSet.getInt("mid"),
                         resultSet.getInt("rid"),
                         resultSet.getString("mname"),
                         resultSet.getString("description"),
                         resultSet.getInt("price"),
                         resultSet.getDouble("rating"),
                         resultSet.getString("image")
                         
                     );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public int updateMenuItem(Menu menuItem) {
        try {
            pstmt = con.prepareStatement(UPDATE_QUERY);
            pstmt.setString(1, menuItem.getMname());
            pstmt.setString(2, menuItem.getDescription());
            pstmt.setInt(3, menuItem.getPrice());
            pstmt.setDouble(4, menuItem.getRating());
            pstmt.setInt(5, menuItem.getMid());
            pstmt.setString(6, menuItem.getImage());

            status = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int deleteMenuItem(int mid) {
        try {
            pstmt = con.prepareStatement(DELETE_QUERY);
            pstmt.setInt(1, mid);
            status = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public ArrayList<Menu> getAllMenuItems() {
        try {
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(FETCH_ALL_QUERY);
            this.menuList = extractMenuFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.menuList;
    }

    public ArrayList<Menu> getOnrid(int rid) {
        ArrayList<Menu> menuByRid = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(FETCH_BY_RID_QUERY);
            pstmt.setInt(1, rid);
            resultSet = pstmt.executeQuery();
            menuByRid = extractMenuFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuByRid;
    }

    private ArrayList<Menu> extractMenuFromResultSet(ResultSet resultSet) {
        
        try {
            while (resultSet.next()) {
            	menuList.add(new Menu(
                        resultSet.getInt("mid"),
                        resultSet.getInt("rid"),
                        resultSet.getString("mname"),
                        resultSet.getString("description"),
                        resultSet.getInt("price"),
                        resultSet.getDouble("rating"),
                        		resultSet.getString("image")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }
}
