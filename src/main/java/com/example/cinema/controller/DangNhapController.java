/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema.controller;

import com.example.cinema.services.UserSevice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "DangNhapController", urlPatterns = {"/dang-nhap"})
public class DangNhapController extends HttpServlet {

    UserSevice userSevice = UserSevice.khoiTaoUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/dangnhap.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (userSevice.dangNhap(req, username, password) == false){
            resp.sendRedirect(req.getContextPath() + "/dang-nhap?loi");
        }
        else{
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }
}
