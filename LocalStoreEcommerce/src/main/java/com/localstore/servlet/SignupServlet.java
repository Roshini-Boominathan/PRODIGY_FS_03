package com.localstore.servlet;

import java.io.IOException;

import com.localstore.dao.UserDAO;
import com.localstore.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")

public class SignupServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
throws IOException {

User user = new User();
user.setName(request.getParameter("name"));
user.setEmail(request.getParameter("email"));
user.setPassword(request.getParameter("password"));

UserDAO dao = new UserDAO();
dao.register(user);

response.sendRedirect("login.jsp");
}
}
