package com.example.cinema.api;

import com.example.cinema.services.PhongChieuService;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PhongchieuAPID", value = "/api/phongchieu/*")
public class PhongchieuAPID extends HttpServlet {
    Gson gson = new Gson();
    PhongChieuService phongChieuService = PhongChieuService.khoitao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("idRap"));
        String ngaychieu = request.getParameter("ngaychieu");
        String thoigianBd = request.getParameter("thoigianbd");
        String thoigianKt = request.getParameter("thoigiankt");
        int idRap = Integer.parseInt(request.getParameter("idRap"));
        PrintWriter out = response.getWriter();
        String json = gson.toJson(phongChieuService.layListPhongchieuSanDung(ngaychieu, thoigianBd, thoigianKt, idRap));
        out.print(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
