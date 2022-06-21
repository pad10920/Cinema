/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema.controller;

import com.example.cinema.model.UserD;
import com.example.cinema.services.UserSevice;

import java.io.IOException;
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
        UserD userD = new UserD();
        userD.setUsername(req.getParameter("username"));
        userD.setEmail(req.getParameter("email"));
        userD.setHoTen(req.getParameter("hovaten"));
        userD.setSdt(req.getParameter("sdt"));
        userD.setPassword(req.getParameter("password"));
        userD.setDiaChi("Bac Giang");
        userD.setQuyen("ROLE_USER");

        userSevice.luuUser(userD);
        resp.sendRedirect("/dang-nhap");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/dangky.jsp").forward(req, resp);
    }
}
