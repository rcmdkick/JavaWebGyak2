package com.example.javawebgyak2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        Repository repo = Repository.getInstance();
        Advertiser user =repo.findAdvertiser(email);
        if (user !=null)
        {
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("mainPage.jsp").forward(request,response);
        } else
        {
            request.getRequestDispatcher("wrongPage.jsp").forward(request,response);
        }
    }

    public void destroy() {
    }
}