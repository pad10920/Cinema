package com.example.cinema.controller;

import com.example.cinema.services.UserSevice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "QuenMatKhauController", value = "/quen-mat-khau")
public class QuenMatKhauController extends HttpServlet {
    UserSevice userSevice = UserSevice.khoiTaoUserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/quenmatkhau.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userSevice.quenMatKhau(request.getParameter("email"));
        request.setAttribute("quenmk", "true");
        request.getRequestDispatcher("/view/quenmatkhau.jsp").forward(request, response);
    }
}
