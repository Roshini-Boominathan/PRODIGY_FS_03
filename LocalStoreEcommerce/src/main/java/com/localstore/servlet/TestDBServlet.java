package com.localstore.servlet;

import java.io.IOException;
import java.sql.Connection;

import com.localstore.util.DBConnection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test-db")

public class TestDBServlet extends HttpServlet {
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws IOException {

	        response.setContentType("text/plain");
	        Connection con = DBConnection.getConnection();

	        if (con != null) {
	            response.getWriter().print("✅ Database Connected Successfully!");
	        } else {
	            response.getWriter().print("❌ Database Connection Failed");
	        }
	    }
}
