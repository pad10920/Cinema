package com.example.cinema.api;

import com.example.cinema.services.RapService;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RapAPI", value = "/api/rap/")
public class RapAPI extends HttpServlet {
    private RapService rapService = RapService.khoitao();
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String json = gson.toJson(rapService.layListRap());
        PrintWriter out = response.getWriter();
        out.print(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
