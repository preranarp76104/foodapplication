<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.foodapplication.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu Items</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #fffacd; /* Light yellow background */
            color: #333; /* Dark grey text color for better readability */
            padding: 40px;
            margin: 0;
        }
        h1 {
            text-align: center;
            color: #555; /* Dark grey for the header */
            font-size: 36px;
            margin-bottom: 30px;
        }
        .container {
            display: flex;
            flex-wrap: wrap;
            gap: 30px;
            justify-content: center;
        }
        .card {
            background: url('menu-image.jpg') no-repeat center center;
            background-size: cover; /* Make the image cover the entire card */
            border-radius: 10px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15); /* Subtle shadow */
            width: 270px;
            height: 400px;
            padding: 20px;
            text-align: center;
            color: white; /* White text to contrast with the greyish background */
            transition: transform 0.3s, box-shadow 0.3s;
            position: relative;
        }
        .card:hover {
            transform: scale(1.05);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* Stronger shadow on hover */
        }
        .card h3 {
            color: #fff; /* White text for the menu name */
            font-size: 24px;
            margin-bottom: 10px;
        }
        .card p {
            color: #fff; /* White text */
            font-size: 14px;
            margin-bottom: 8px;
        }
        .card strong {
            color: #ffd700; /* Golden Yellow for strong text */
        }
        .card .price {
            font-size: 16px;
            font-weight: bold;
            color: #ffd700; /* Golden yellow for price */
        }
        .card .rating {
            font-size: 16px;
            color: #ffd700; /* Golden yellow for rating */
        }
        /* Dark overlay to make the text stand out */
        .card::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: rgba(0, 0, 0, 0.4); /* Dark overlay */
            border-radius: 10px;
        }
        .card-content {
            position: relative;
            z-index: 1;
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

    .nav-links a:first-child {
        /* Align <- to the left */
        text-align: left;
    }

    .nav-links a:last-child {
        /* Align -> to the right */
        text-align: right;
    }
    </style>
</head>
<body>

    <h1>Delicious Menu Items</h1>

    <div class="container">
        <%
            ArrayList<Menu> mList = (ArrayList<Menu>) session.getAttribute("menuByRid");
            if (mList != null && !mList.isEmpty()) {
                for (Menu m : mList) {
        %>
            <div class="card">
                <div class="card-content">
                     <img src="<%= m.getImage() %>" alt="<%= m.getMname() %>" style="width:100%; height:auto; border-radius: 8px;">
                    <h3><%= m.getMname() %></h3>
                    <p><strong>Description:</strong> <%= m.getDescription() %></p>
                    <p class="price"><strong>Price:</strong> ₹<%= m.getPrice() %></p>
                    <p class="rating"><strong>Ratings:</strong> <%= m.getRating() %> / 5</p>
                   
                     <form action="cart" method="post">
                      <label for="quantity">Update Quantity:</label>
                      <select name="quantity" id="quantity">
                      <% for (int i = 1; i <= 10; i++) { %>
                      <option value="<%= i %>"><%= i %></option>
                        <% } %>
                       </select>
                     <input type="hidden" name="mid" value="<%= m.getMid() %>">
                     <button type="submit">Add to Cart</button>
                     </form>
                </div>
            </div>
        <%
                }
            } else {
        %>
            <p>No menu items available.</p>
        <%
            }
        %>
        <div class="nav-links">
        <a href="Home.jsp"><-</a>
        <a href="cart.jsp">-></a>
    </div>
    </div>

</body>
</html>
