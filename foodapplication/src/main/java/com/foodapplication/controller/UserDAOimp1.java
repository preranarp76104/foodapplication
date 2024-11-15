package com.foodapplication.controller;

import java.sql.*;

import java.util.ArrayList;
import com.foodapplication.model.User;
import com.tap.secret.Decrypt;
import com.tap.secret.Encrypt;
import com.foodapplication.dbUtils.DBUtils;

public class UserDAOimp1 implements USERdao {

    private final String INSERT_QUERY = "INSERT INTO user(username, email, password, mobile) VALUES(?, ?, ?, ?)";
    private final String FETCH_SPECIFIC_QUERY = "SELECT * FROM user WHERE email = ?";
    private final String UPDATE_QUERY = "UPDATE user SET uname = ?, email = ?, password = ?, mobile = ? WHERE email = ?";
    private final String DELETE_QUERY = "DELETE FROM user WHERE email = ?";
    private final String FETCH_ALL_QUERY = "SELECT * FROM user";
    
    private String url = "jdbc:mysql://localhost:3306/project";
    private String username = "root";
    private String password = "root";
    private Connection con;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultset;
    
    ArrayList<User> userlist = new ArrayList<>();
    User user;

    public UserDAOimp1() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addUser(User u) {
        int status = 0;
        try {
            pstmt = con.prepareStatement(INSERT_QUERY);
            // Encrypt fields before saving to the database
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getEmail());
            pstmt.setString(3, u.getPassword());
            pstmt.setInt(4, u.getMobile());
            status = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return status;
    }

    @Override
    public User fetchSpecific(String email) {
        User user = null;
        try {
            pstmt = con.prepareStatement(FETCH_SPECIFIC_QUERY);
            pstmt.setString(1, email);  // Use the already encrypted email
            resultset = pstmt.executeQuery();
            if (resultset.next()) {
               
                user = new User(
                    resultset.getString("username"),
                    resultset.getString("email"),
                   resultset.getString("password"),
                    resultset.getInt("mobile")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return user;
    }

    @Override
    public int updateUser(User u) {
        int status = 0;
        try {
            pstmt = con.prepareStatement(UPDATE_QUERY);
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getEmail());
            pstmt.setString(3, u.getPassword());
            pstmt.setInt(4, u.getMobile());
            pstmt.setString(5, u.getEmail());
            status = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return status;
    }

    @Override
    public int deleteUser(String email) {
        int status = 0;
        try {
            pstmt = con.prepareStatement(DELETE_QUERY);
            pstmt.setString(1, email);
            status = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return status;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        userlist.clear();
        try {
            stmt = con.createStatement();
            resultset = stmt.executeQuery(FETCH_ALL_QUERY);
            userlist = extractUserFromResultSet(resultset);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return userlist;
    }

    private ArrayList<User> extractUserFromResultSet(ResultSet resultset) {
        ArrayList<User> users = new ArrayList<>();
        try {
            while (resultset.next()) {
                users.add(new User(resultset.getInt("userid"),
                                   Decrypt.decrypt(resultset.getString("username")),
                                   Decrypt.decrypt(resultset.getString("email")),
                                		   Decrypt.decrypt(resultset.getString("password")),
                                				   resultset.getInt("mobile")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean registerUser(User user) {
        boolean isRegistered = false;
        try {
            pstmt = con.prepareStatement(INSERT_QUERY);
            // Encrypt fields before saving to the database
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setInt(4, user.getMobile());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                isRegistered = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error in registration: " + e.getMessage());
        } finally {
            closeResources();
        }
        return isRegistered;
    }

    private void closeResources() {
        try {
            if (resultset != null) resultset.close();
            if (pstmt != null) pstmt.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
}
