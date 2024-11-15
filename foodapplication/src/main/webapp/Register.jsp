<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: url('https://img.freepik.com/premium-photo/top-view-food-arrangement-with-pizza-boxes_23-2148247880.jpg') no-repeat center center fixed;
            background-size: cover;
        }
        .container {
            width: 350px;
            padding: 25px;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            box-shadow: 0px 6px 12px rgba(0, 0, 0, 0.3);
            text-align: center;
        }
        .container label {
            font-weight: bold;
            color: #333;
            margin-top: 10px;
            text-align: left;
            display: inline-block;
            width: 100%;
        }
        .container input[type="text"],
        .container input[type="password"] {
            width: 100%;
            padding: 12px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .container input[type="submit"] {
            width: 100%;
            padding: 12px;
            margin-top: 15px;
            background-color: #ffcc00;
            border: none;
            color: white;
            font-weight: bold;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .container input[type="submit"]:hover {
            background-color: #e0b300;
        }
    </style>
</head>
<body>
    <div class="container">
        <form action="Register" method="post" style="display: flex; flex-direction: column;">
            <label for="username">Username</label>
            <input type="text" name="username" id="username" placeholder="Enter your username" required>

            <label for="email">Email</label>
            <input type="text" name="email" id="email" placeholder="Enter your email" required>

            <label for="password">Password</label>
            <input type="password" name="password" id="password" placeholder="Enter your password" required>

            <label for="confirmPassword">Confirm Password</label>
            <input type="password" name="confirmPassword" id="confirmPassword" placeholder="Confirm your password" required>

            <label for="phone">Phone Number</label>
            <input type="text" name="phone" id="phone" placeholder="Enter your phone number" required>

            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>

