<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.localstore.model.Product" %>

<!DOCTYPE html>
<html>
<head>
    <title>Product Details</title>
</head>
<body>

<%
    Product p = (Product) request.getAttribute("product");
%>

<h2><%= p.getName() %></h2>
<p><%= p.getDescription() %></p>
<p><strong>Price:</strong> ₹<%= p.getPrice() %></p>

<form action="add-to-cart" method="post">
    <input type="hidden" name="id" value="<%= p.getId() %>">

    Quantity:
    <input type="number" name="qty" value="1" min="1">

    <br><br>
    <button type="submit">Add to Cart</button>
</form>

<br>
<a href="products">← Back to Products</a>

</body>
</html>