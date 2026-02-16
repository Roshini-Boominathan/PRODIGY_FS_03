package com.localstore.servlet;

import java.io.IOException;

import com.localstore.dao.UserDAO;
import com.localstore.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
throws IOException {

String email = request.getParameter("email");
String password = request.getParameter("password");

UserDAO dao = new UserDAO();
User user = dao.login(email, password);

if (user != null) {
HttpSession session = request.getSession();
session.setAttribute("user", user);
response.sendRedirect("products");
} else {
response.sendRedirect("login.jsp");
}
}
}
