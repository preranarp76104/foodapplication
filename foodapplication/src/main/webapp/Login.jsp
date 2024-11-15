<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body style="font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; background: url('https://img.freepik.com/premium-photo/top-view-food-arrangement-with-pizza-boxes_23-2148247880.jpg?semt=ais_hybrid.jpg') no-repeat center center fixed; background-size: cover;">
    <div style="width: 300px; padding: 20px; background-color: rgba(255, 255, 255, 0.8); border-radius: 8px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2); text-align: center;">
        <form action="Login" style="display: flex; flex-direction: column;">
            <label for="email" style="font-weight: bold; margin-top: 10px; color: #333;">Email</label>
            <input type="text" name="email" id="email" placeholder="Enter your email" style="width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #ccc; border-radius: 4px;">
            
            <label for="password" style="font-weight: bold; margin-top: 10px; color: #333;">Password</label>
            <input type="password" name="password" id="password" placeholder="Enter your password" style="width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #ccc; border-radius: 4px;">
            
            <input type="submit" value="Login" style="width: 100%; padding: 10px; background-color: #ffcc00; border: none; color: white; font-weight: bold; cursor: pointer; border-radius: 4px;">
        </form>
    </div>
</body>
</html>










