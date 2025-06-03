package com.data.session04.controller;

import com.data.session04.model.MonthRevenue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "RevenueStatsServlet ", value = "/revenueStats")
public class RevenueStatsServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<MonthRevenue> revenues = new ArrayList<>();
        revenues.add(new MonthRevenue("January", 15000));
        revenues.add(new MonthRevenue("February", 12000));
        revenues.add(new MonthRevenue("March", 18000));
        revenues.add(new MonthRevenue("April", 9000));
        revenues.add(new MonthRevenue("May", 20000));

        request.setAttribute("revenues", revenues);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/revenueStats.jsp");
        dispatcher.forward(request, response);
    }


}