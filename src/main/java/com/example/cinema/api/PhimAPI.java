/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema.api;

import com.example.cinema.dao.PhimDAO;
import com.example.cinema.model.Phim;
import com.example.cinema.utils.test;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 *
 * @author cuong
 */
@WebServlet(name = "PhimAPI", urlPatterns = {"/api/phim/*"})
@MultipartConfig
public class PhimAPI extends HttpServlet {

    private PhimDAO phimDAO = new PhimDAO();
    private Gson gson = new Gson();
    private test nvc = new test();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("application/json; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        
        // Tất cả phim
        Pattern pattern = Pattern.compile("api/phim$");
        Matcher matcher = pattern.matcher(req.getRequestURL());
        
        
        //Phim theo id
        Pattern pattern1 = Pattern.compile("api/phim/(\\d++)$");
        Matcher matcher1 = pattern1.matcher(req.getRequestURL());
        
        //Phim theo loại
        Pattern pattern2 = Pattern.compile("api/phim/loai/(\\d++)$");
        Matcher matcher2 = pattern2.matcher(req.getRequestURL());
        if(matcher.find()){
            String json = gson.toJson(phimDAO.findAll());
            out.print(json);
        }
        else if(matcher1.find()){
            int id = Integer.parseInt(matcher1.group(1));
            String json = gson.toJson(phimDAO.getPhimById(id));
            out.print(json);
        }
        else if(matcher2.find()){
                int loai = Integer.parseInt(matcher2.group(1));
                
//                String json = gson.toJson(phimDAO.getPhimByLoai(loai));
                

                out.print(gson.toJson(phimDAO.getPhimByLoai(loai)));
                
                
        }
        else{
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Pattern pattern1 = Pattern.compile("api/phim/insert");
        Matcher matcher1 = pattern1.matcher(req.getRequestURL());
        resp.setContentType("application/json; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        
        String tenPhim = req.getParameter("tenPhim");
        int thoiLuong = Integer.parseInt(req.getParameter("thoiLuong"));
        String moTa = req.getParameter("moTa");
        String quocGia = req.getParameter("quocGia");
        String anhPhim = req.getPart("anhPhim").getSubmittedFileName();
        int trangThai = Integer.parseInt(req.getParameter("trangThai"));
        
        String anhPhimConvert = "IM" + Integer.toString(phimDAO.getLastIDPhim()) + ".jpg";
        test.save(anhPhim, anhPhimConvert);
        
        Phim phim = new Phim(tenPhim, thoiLuong, moTa, quocGia, anhPhimConvert, trangThai);
        phimDAO.insert(phim);
        
        String json = gson.toJson(phim);
        out.print(json);
        
//            nvc.save(req.getPart("file").getSubmittedFileName(),"");

                 
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Pattern pattern1 = Pattern.compile("api/phim/sua/(\\d++)$");
        Matcher matcher1 = pattern1.matcher(req.getRequestURL());
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        if(matcher1.find()){
            
        }
        else{
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Pattern pattern1 = Pattern.compile("api/phim/xoa/(\\d++)$");
        Matcher matcher1 = pattern1.matcher(req.getRequestURL());
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        if(matcher1.find()){
            int id = Integer.parseInt(matcher1.group(1));
            String json = gson.toJson(phimDAO.getPhimById(id));
            phimDAO.deleteById(id);
            
            out.print(json);
                
        }
        else{
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    
    
    

    
    

}
