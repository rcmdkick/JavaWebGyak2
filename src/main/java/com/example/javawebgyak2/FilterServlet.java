package com.example.javawebgyak2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name = "filterServlet", value = "/filter-servlet")
public class FilterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String[] keywords = request.getParameterValues("kereses");
        Repository repo = Repository.getInstance();

        ArrayList<FilteredModel> filtered = new ArrayList<FilteredModel>();
        for (Advertiser a: repo.getAdvertisers()) {
            for (Product p:a.getSelling()) {
                for (String keyword:keywords) {
                    if (keyword.equals(p.getKeyword()))
                    {
                        filtered.add(new FilteredModel(a,p));
                    }
                }
            }
        }
        request.getSession().setAttribute("filtered",filtered);
        request.getRequestDispatcher("filterPage.jsp").forward(request,response);

    }

    public void destroy() {
    }
}