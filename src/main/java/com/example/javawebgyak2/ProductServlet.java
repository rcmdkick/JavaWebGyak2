package com.example.javawebgyak2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ProdServlet", value = "/prod-servlet")
public class ProductServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String keyword = request.getParameter("keyword");
        Advertiser user = (Advertiser) request.getSession().getAttribute("user");
        Product p = new Product(name,price,keyword);
        user.addProduct(p);

        request.getRequestDispatcher("mainPage.jsp").forward(request,response);
    }

    public void destroy() {
    }
}