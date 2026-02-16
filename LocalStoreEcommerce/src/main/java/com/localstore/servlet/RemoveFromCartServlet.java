package com.localstore.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.localstore.model.CartItem;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/remove-from-cart")

public class RemoveFromCartServlet extends HttpServlet {
	
	  @Override
	    protected void doGet(HttpServletRequest request,
	                         HttpServletResponse response)
	            throws IOException {

	        int productId =
	            Integer.parseInt(request.getParameter("id"));

	        HttpSession session = request.getSession();
	        List<CartItem> cart =
	            (List<CartItem>) session.getAttribute("cart");

	        if (cart != null) {
	            Iterator<CartItem> it = cart.iterator();
	            while (it.hasNext()) {
	                CartItem item = it.next();
	                if (item.getProduct().getId() == productId) {
	                    it.remove();
	                    break;
	                }
	            }
	        }

	        session.setAttribute("cart", cart);
	        response.sendRedirect("cart.jsp");
	    }
}
