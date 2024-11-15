<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodapplication.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.foodapplication.model.Restaurant" %>
<%@ page import="com.tap.secret.Decrypt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Food App - Home</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 40px;
            background-color: #fffacd;
            background-size: cover;
            color: #333;
        }
        h1 {
            text-align: center;
            color: #006400; /* Dark green */
            font-size: 36px;
            margin-bottom: 30px;
        }
        .welcome-message {
            font-size: 20px;
            margin-bottom: 20px;
            color: #006400; /* Dark green */
            text-align: center;
        }
        .card-container {
            display: flex;
            flex-wrap: wrap;
            gap: 30px;
            justify-content: center;
        }
        .card {
            background-color: #ffffff; /* Changed to plain white */
            border: 1px solid #006400; /* Dark green border */
            border-radius: 8px;
            width: 270px; /* Same width for cards */
            padding: 20px;
            box-shadow: 0 6px 12px rgba(0, 100, 0, 0.2); /* Dark green shadow */
            box-sizing: border-box;
            position: relative;
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .card:hover {
            transform: scale(1.05);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* Stronger shadow on hover */
        }
        .card h3 {
            color: #006400; /* Dark green */
            font-size: 24px;
            margin-bottom: 10px;
        }
        .card p {
            color: #003300; /* Darker green for text */
            font-size: 14px;
            margin-bottom: 8px;
        }
        .card button {
            margin-top: 10px;
            padding: 8px 12px;
            background-color: #006400; /* Dark green button */
            border: none;
            color: #fff;
            cursor: pointer;
            border-radius: 4px;
        }
        .card button:hover {
            background-color: #008000; /* Brighter green on hover */
        }
        .card .menu-button {
            background-color: #ffd700; /* Golden yellow */
        }
        .card .menu-button:hover {
            background-color: #ffcc00; /* Lighter yellow on hover */
        }
        .card-content {
            position: relative;
            z-index: 1;
        }

        /* Styles for the login section */
        .login-section {
            text-align: center;
            margin-top: 50px;
            padding: 20px;
            background: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */
            border-radius: 10px;
            width: 60%;
            margin-left: auto;
            margin-right: auto;
        }
        .login-section a {
            color: #006400;
            font-weight: bold;
            text-decoration: none;
        }
        .login-section a:hover {
            color: #008000;
        }

    </style>
</head>
<body>

    <h1>Welcome to Food App</h1>

    <%
        User user = (User) session.getAttribute("loggedInUser");
        if (user != null) {
    %>
        <div class="welcome-message">Welcome, <%= Decrypt.decrypt(user.getUsername())%></div>
    <%
        } else {
    %>
        <div class="login-section">
            <p>User not logged in. Please <a href="Login.jsp">login</a>.</p>
        </div>
    <%
        }
    %>

    <div class="card-container">
    <%
        ArrayList<Restaurant> rList = (ArrayList<Restaurant>) session.getAttribute("restaurantList");
        if (rList != null && !rList.isEmpty()) {
            for (Restaurant res : rList) {
    %>
        <div class="card">
            <div class="card-content">
                 <img src="<%= res.getImage() %>" alt="<%= res.getRname() %>" style="width:100%; height:auto; border-radius: 8px;">
                <h3><%= res.getRname() %></h3>
                <p><strong>Cuisine Type:</strong> <%= res.getCuisineType() %></p>
                <p><strong>Address:</strong> <%= res.getAddress() %></p>
                <p><strong>Ratings:</strong> <%= res.getRatings() %></p>
                <a href="menuByRid?rid=<%=res.getRid() %>"><button class="menu-button">View Menu</button></a>
            </div>
        </div>
    <%
            }
        } else {
    %>
        <p>No restaurants available to display.</p>
    <%
        }
    %>
    
    </div>

</body>
</html>
