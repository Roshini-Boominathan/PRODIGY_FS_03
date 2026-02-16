package com.localstore.servlet;

import java.io.IOException;

import com.localstore.dao.ProductDAO;
import com.localstore.model.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product")

public class ProductDetailsServlet extends HttpServlet {
	
	 @Override
	    protected void doGet(HttpServletRequest request,
	                         HttpServletResponse response)
	            throws IOException {

	        String idParam = request.getParameter("id");

	        if (idParam == null) {
	            response.sendRedirect("products");
	            return;
	        }

	        int id = Integer.parseInt(idParam);

	        ProductDAO dao = new ProductDAO();
	        Product product = dao.getProductById(id);

	        request.setAttribute("product", product);

	        try {
	            RequestDispatcher rd =
	                request.getRequestDispatcher("product-details.jsp");
	            rd.forward(request, response);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
