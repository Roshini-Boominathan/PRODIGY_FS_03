package com.localstore.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.localstore.model.CartItem;
import com.localstore.util.DBConnection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")

public class CheckoutServlet extends HttpServlet {
	
	 @Override
	    protected void doPost(HttpServletRequest request,
	                          HttpServletResponse response)
	            throws IOException {

	        HttpSession session = request.getSession();
	        List<CartItem> cart =
	            (List<CartItem>) session.getAttribute("cart");

	        if (cart == null || cart.isEmpty()) {
	            response.sendRedirect("cart.jsp");
	            return;
	        }

	        double total = 0;
	        for (CartItem item : cart) {
	            total += item.getTotalPrice();
	        }

	        try (Connection con = DBConnection.getConnection()) {

	            String sql = "INSERT INTO orders (total) VALUES (?)";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setDouble(1, total);
	            ps.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        // Clear cart after order
	        session.removeAttribute("cart");

	        response.sendRedirect("order-success.jsp");
	    }
}
