package com.localstore.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.localstore.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products")   // 👈 MUST BE EXACT
public class ProductListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("🔥 SERVLET HIT");

        List<Product> products = new ArrayList<>();

        Product p = new Product();
        p.setName("HARDCODE TEST PRODUCT");
        p.setPrice(999);

        products.add(p);

        req.setAttribute("products", products);
        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }
}