package com.example.cinema.api;

import com.example.cinema.model.Phim;
import com.example.cinema.services.PhimService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
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
            Phim phim = phimService.layPhimById(idPhim);
            String json = gson.toJson(phim);
            out.print(json);
        }
        else if (tuKhoa == null){
            // lay list phim
            String json = gson.toJson(phimService.layListPhim());
            out.print(json);
        }
        else{
            List<Phim> phimList = phimService.layListPhimByTen(tuKhoa);
            out.print(gson.toJson(phimList));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part anhPhim = request.getPart("hinh");
        String theLoai = request.getParameter("theLoai");

        Phim phim = new Phim();
        phim.setTenPhim(request.getParameter("tenPhim"));
        phim.setThoiLuong(Integer.parseInt(request.getParameter("thoiLuong")));
        phim.setMoTa(request.getParameter("moTa"));
        phim.setQuocGia(request.getParameter("quocGia"));
        phim.setTrangThai(Integer.parseInt(request.getParameter("trangThai")));

        String location = getServletContext().getRealPath("/static/img/");
        phimService.themPhim(phim, anhPhim, theLoai, location);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Phim phim = new Phim();
        String theLoai = request.getParameter("theLoai");
        phim.setTenPhim(request.getParameter("tenPhim"));
        phim.setIdPhim(Integer.parseInt(request.getParameter("idPhim")));
        phim.setThoiLuong(Integer.parseInt(request.getParameter("thoiLuong")));
        phim.setMoTa(request.getParameter("moTa"));
        phim.setQuocGia(request.getParameter("quocGia"));
        phim.setTrangThai(Integer.parseInt(request.getParameter("trangThai")));
        phimService.capNhapPhim(phim, theLoai);
    }
}
