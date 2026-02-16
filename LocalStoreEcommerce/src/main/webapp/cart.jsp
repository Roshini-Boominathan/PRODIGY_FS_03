<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.localstore.model.CartItem" %>

<!DOCTYPE html>
<html>
<head>
    <title>My Cart</title>
    <style>
        table {
            border-collapse: collapse;
            width: 70%;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        a {
            color: red;
            text-decoration: none;
        }
        button {
            padding: 8px 15px;
            font-size: 14px;
        }
    </style>
</head>
<body>

<h2>🛒 My Cart</h2>

<%
    List<CartItem> cart =
        (List<CartItem>) session.getAttribute("cart");

    double total = 0;
%>

<%
    if (cart == null || cart.isEmpty()) {
%>
        <p>Your cart is empty.</p>
        <a href="products">← Continue Shopping</a>
<%
    } else {
%>
        <table border="1">
            <tr>
                <th>Product</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>Action</th>
            </tr>

<%
        for (CartItem item : cart) {
            total += item.getTotalPrice();
%>
            <tr>
                <td><%= item.getProduct().getName() %></td>
                <td>₹<%= item.getProduct().getPrice() %></td>
                <td><%= item.getQuantity() %></td>
                <td>₹<%= item.getTotalPrice() %></td>
                <td>
                    <a href="remove-from-cart?id=<%= item.getProduct().getId() %>">
                        Remove
                    </a>
                </td>
            </tr>
<%
        }
%>
            <tr>
                <td colspan="3"><strong>Grand Total</strong></td>
                <td colspan="2"><strong>₹<%= total %></strong></td>
            </tr>
        </table>

        <br>

        <!-- STEP 8.2: Place Order Button -->
        <form action="checkout" method="post">
            <button type="submit">Place Order</button>
        </form>

        <br>
        <a href="products">← Continue Shopping</a>
<%
    }
%>

</body>
</html>