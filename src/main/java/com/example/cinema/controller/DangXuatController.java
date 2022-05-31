/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema.controller;

import com.example.cinema.utils.SessionUtil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DangXuatController", urlPatterns = {"/dang-xuat"})
public class DangXuatController extends HttpServlet {

    SessionUtil sessionUtil = SessionUtil.khoiTaoSession();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sessionUtil.xoaSession(req, "USER");
        resp.sendRedirect("/");
    }

    

}
