package com.example.cinema.api;

import com.example.cinema.model.PhimD;
import com.example.cinema.services.PhimService;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@MultipartConfig
@WebServlet(name = "QuanLyPhimAPI", value = "/api/quanlyphim/*")
public class QuanLyPhimAPI extends HttpServlet {
    private static final Gson gson = new Gson();
    PhimService phimService = PhimService.khoiTao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Pattern pattern = Pattern.compile("/api/quanlyphim/(\\d++)$");
        Matcher matcher = pattern.matcher(request.getRequestURL());
        String tuKhoa = request.getParameter("key");
        PrintWriter out = response.getWriter();
        if (matcher.find()){
            int idPhim = Integer.parseInt(matcher.group(1));
            PhimD phimD = phimService.layPhimById(idPhim);
            String json = gson.toJson(phimD);
            out.print(json);
        }
        else if (tuKhoa == null){
            // lay list phim
            String json = gson.toJson(phimService.layListPhim());
            out.print(json);
        }
        else{
            List<PhimD> phimDList = phimService.layListPhimByTen(tuKhoa);
            out.print(gson.toJson(phimDList));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part anhPhim = request.getPart("hinh");
        String theLoai = request.getParameter("theLoai");

        PhimD phimD = new PhimD();
        phimD.setTenPhim(request.getParameter("tenPhim"));
        phimD.setThoiLuong(Integer.parseInt(request.getParameter("thoiLuong")));
        phimD.setMoTa(request.getParameter("moTa"));
        phimD.setQuocGia(request.getParameter("quocGia"));
        phimD.setTrangThai(Integer.parseInt(request.getParameter("trangThai")));

        String location = getServletContext().getRealPath("/static/img/");
        phimService.themPhim(phimD, anhPhim, theLoai, location);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PhimD phimD = new PhimD();
        String theLoai = request.getParameter("theLoai");
        phimD.setTenPhim(request.getParameter("tenPhim"));
        phimD.setIdPhim(Integer.parseInt(request.getParameter("idPhim")));
        phimD.setThoiLuong(Integer.parseInt(request.getParameter("thoiLuong")));
        phimD.setMoTa(request.getParameter("moTa"));
        phimD.setQuocGia(request.getParameter("quocGia"));
        phimD.setTrangThai(Integer.parseInt(request.getParameter("trangThai")));
        phimService.capNhapPhim(phimD, theLoai);
    }
}
