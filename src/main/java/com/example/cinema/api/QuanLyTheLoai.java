package com.example.cinema.api;

import com.example.cinema.services.TheLoaiService;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "QuanLyTheLoai", value = "/api/quanlytheloai/*")
public class QuanLyTheLoai extends HttpServlet {
    Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Pattern pattern = Pattern.compile("api/quanlytheloai/(\\d++)$");
        Matcher matcher = pattern.matcher(request.getRequestURL());
        PrintWriter out = response.getWriter();
        TheLoaiService service = TheLoaiService.khoiTao();
        if(matcher.find()){
            // tim bang ID
        }
        else{
            // lay danh sach
            String json = gson.toJson(service.layListTheLoai());
            out.print(json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
