package com.example.cinema.api;

import com.example.cinema.model.User;
import com.example.cinema.services.UserSevice;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DangKyAPI", value = "/api/dang-ky")
@MultipartConfig
public class DangKyAPI extends HttpServlet {

    UserSevice userSevice = UserSevice.khoiTaoUserService();
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        PrintWriter printWriter = response.getWriter();
        printWriter.print(userSevice.dangKy(username, email));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        System.out.println("do post dang ky");
        PrintWriter printWriter = response.getWriter();
        printWriter.print(username + ' ' + email);
    }
}
