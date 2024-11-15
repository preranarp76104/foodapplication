<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.foodapplication.model.CartItem" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        color: #333;
        margin: 0;
        padding: 0;
    }

    .cart-container {
        width: 70%;
        margin: 40px auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }

    .cart-container h2 {
        text-align: center;
        color: #444;
    }

    .cart-item {
        display: flex;
        justify-content: space-between;
        padding: 12px 0;
        border-bottom: 1px solid #ddd;
        align-items: center;
    }

    .cart-item h3 {
        margin: 0;
        font-size: 1.1em;
    }

    .cart-item p {
        margin: 5px 0;
        font-size: 1em;
        color: #555;
    }

    .item-actions {
        display: flex;
        gap: 10px;
        align-items: center;
    }

    .quantity-dropdown {
        padding: 5px;
        font-size: 1em;
        border-radius: 4px;
        border: 1px solid #ddd;
    }

    .update-btn, .delete-btn, .clear-cart-btn {
        padding: 6px 12px;
        font-size: 0.9em;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        color: #fff;
    }

    .update-btn {
        background-color: #28a745;
    }

    .delete-btn {
        background-color: #dc3545;
    }

    .clear-cart-btn {
        background-color: #007bff;
    }

    .cart-footer {
        text-align: right;
        margin-top: 20px;
        font-size: 1.2em;
        color: #333;
    }

    .empty-cart {
        text-align: center;
        font-size: 1.1em;
        color: #888;
    }

    .nav-links {
        position: fixed;
        top: 10px;
        width: 100%;
        display: flex;
        justify-content: space-between;
        padding: 0 20px;
    }

    .nav-links a {
        text-decoration: none;
        padding: 10px 20px;
        background-color: transparent;
        border: 2px solid #007bff; /* Blue border */
        color: #007bff; /* Blue text */
        border-radius: 4px;
        font-size: 1em;
        transition: background-color 0.3s, color 0.3s;
    }

    .nav-links a:hover {
        background-color: #007bff;
        color: white;
    }
</style>
</head>
<body>

<div class="cart-container">
    <h2>Your Cart</h2>
    <%
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        double totalAmount = 0.0;

        if (cart != null && !cart.isEmpty()) { 
            for (CartItem item : cart.values()) { 
                totalAmount += item.getQuantity() * item.getPrice();
    %>
            <div class="cart-item">
                <div class="item-details">
                    <h3><%= item.getName() %></h3>
                    <p>Price: ₹<%= item.getPrice() %> each</p>
                    <p>Ratings:<%= item.getRating() %> / 5</p>
                    
                    <p>Total: ₹<%= item.getPrice() * item.getQuantity() %></p>
                </div>
                <div class="item-actions">
                    <!-- Update Cart Form -->
                    <form action="Updatecart" method="post">
                        <strong>Quantity:</strong>
                        <select name="quantity">
                            <% for (int i = 1; i <= 10; i++) { %>
                                <option value="<%= i %>" <%= item.getQuantity() == i ? "selected" : "" %>><%= i %></option>
                            <% } %>
                        </select>
                        <input type="hidden" name="mid" value="<%= item.getMid() %>">
                        <button type="submit" class="update-btn">Update</button>
                    </form>

                    <!-- Delete Item Form -->
                    <form action="Deletecartitem" method="post">
                        <input type="hidden" name="mid" value="<%= item.getMid() %>">
                        <button type="submit" class="delete-btn">Delete</button>
                    </form>
                </div>
            </div>
    <% 
            } 
    %>
        <div class="cart-footer">
            <p><strong>Total Amount: ₹<%= totalAmount %></strong></p>
            <form action="Clearcart" method="get">
                <button type="submit" class="clear-cart-btn">Clear Cart</button>
            </form>
        </div>
    <% } else { %>
        <p class="empty-cart">Your cart is empty.</p>
    <% } %>

    <!-- Navigation Links -->
    <div class="nav-links">
        <a href="Menu.jsp"><-</a>
        <a href="nextPage.jsp">-></a>
    </div>
</div>

</body>
</html>
