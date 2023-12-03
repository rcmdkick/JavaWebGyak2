package com.example.javawebgyak2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.io.IOException;

@WebServlet(name = "resServlet", value = "/res-servlet")
public class ReserveServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        ArrayList<FilteredModel> filtered = (ArrayList<FilteredModel>) request.getSession().getAttribute("filtered");
       Advertiser a = (Advertiser) request.getSession().getAttribute("user");
        /* Product p = filtered.stream().filter(
                t-> id.equals(t.getProduct()
                        .getName())).findFirst().orElse(null);
    */

        for (FilteredModel f:filtered) {
            if (f.getProduct().getName().equals(id))
            {
                f.getProduct().setReservedby(a.getEmail());
                break;
            }
        }
        request.getRequestDispatcher("filterPage.jsp").forward(request,response);
    }


    public void destroy() {
    }
}