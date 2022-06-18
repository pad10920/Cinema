/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema.controller;

import com.example.cinema.dao.UserDAO;
import com.example.cinema.model.User;
import com.example.cinema.services.UserSevice;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DangKyController", urlPatterns = {"/dang-ky/*"})
public class DangKyController extends HttpServlet {
    UserSevice userSevice = UserSevice.khoiTaoUserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setEmail(req.getParameter("email"));
        user.setHoTen(req.getParameter("hovaten"));
        user.setSdt(req.getParameter("sdt"));
        user.setPassword(req.getParameter("password"));
        user.setDiaChi("Bac Giang");
        user.setQuyen("ROLE_USER");

        userSevice.luuUser(user);
        resp.sendRedirect("/dang-nhap");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/dangky.jsp").forward(req, resp);
    }
}
