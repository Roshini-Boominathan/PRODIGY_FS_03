package com.localstore.servlet;

import com.localstore.dao.ProductDAO;
import com.localstore.model.CartItem;
import com.localstore.model.Product;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@jakarta.servlet.annotation.WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        int productId =
            Integer.parseInt(request.getParameter("id"));

        ProductDAO dao = new ProductDAO();
        Product product = dao.getProductById(productId);

        HttpSession session = request.getSession();
        List<CartItem> cart =
            (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        boolean found = false;
        for (CartItem item : cart) {
            if (item.getProduct().getId() == productId) {
                item.setQuantity(item.getQuantity() + 1);
                found = true;
                break;
            }
        }

        if (!found) {
            cart.add(new CartItem(product, 1));
        }

        session.setAttribute("cart", cart);
        response.sendRedirect("products");
    }
}