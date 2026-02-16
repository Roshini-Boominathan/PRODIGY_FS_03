<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.localstore.model.Product" %>

<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
    <style>
        .product {
            border: 1px solid #ccc;
            padding: 15px;
            margin: 15px;
            width: 300px;
        }
        a {
            text-decoration: none;
            color: #2c3e50;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<h2>🛒 Available Products</h2>

<%
    List<Product> products =
        (List<Product>) request.getAttribute("productList");

    if (products == null || products.isEmpty()) {
%>
        <p>No products available.</p>
<%
    } else {
        for (Product p : products) {
%>
            <div class="product">
                <h3>
                    <a href="product?id=<%= p.getId() %>">
                        <%= p.getName() %>
                    </a>
                </h3>

                <p><%= p.getDescription() %></p>
                <p><strong>Price:</strong> ₹<%= p.getPrice() %></p>
            </div>
<%
        }
    }
%>

</body>
</html>