package com.example.cinema.api;

import com.example.cinema.model.SuatchieuD;
import com.example.cinema.services.SuatChieuService;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@MultipartConfig
@WebServlet(name = "QuanLySuatChieuAPI", value = "/api/quanlysuatchieu/*")
public class QuanLySuatChieuAPI extends HttpServlet {
    private SuatChieuService suatChieuService = SuatChieuService.khoitao();
    Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Pattern pattern = Pattern.compile("/api/quanlysuatchieu/(\\d++)$");
        Matcher matcher = pattern.matcher(request.getRequestURL());
        String tuKhoa = request.getParameter("key");
        String byRap = request.getParameter("rapId");
        PrintWriter out = response.getWriter();
        if (matcher.find()){
            // suat chieu by ID
            int idSuatchieu = Integer.parseInt(matcher.group(1));
            String json = gson.toJson(suatChieuService.laySuatChieuById(idSuatchieu));
            out.print(json);
        }
        else if (tuKhoa == null){
            // lay list suat chieu
            if (byRap != null){
                // list suat chieu by rap id;
                int idRap = Integer.parseInt(byRap);
                String json = gson.toJson(suatChieuService.layListSuatchieuByrap(idRap));
                out.print(json);
            }
        }
        else{

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPhim = Integer.parseInt(request.getParameter("idphim"));
        int giaVe = Integer.parseInt(request.getParameter("giave"));
        String thoigianbd = request.getParameter("thoigianbd");
        String thoigiankt = request.getParameter("thoigiankt");
        String ngaychieu = request.getParameter("ngaychieu");
        String phongchieu = request.getParameter("phongchieu");


        SuatchieuD suatchieuD = suatChieuService.taoSuatChieuByInfo(ngaychieu, thoigianbd, thoigiankt, giaVe);
        suatChieuService.themSuatChieu(suatchieuD, idPhim, phongchieu);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        int idPhim = Integer.parseInt(request.getParameter("idphim"));
        int giaVe = Integer.parseInt(request.getParameter("giave"));
        int idSuatchieu = Integer.parseInt(request.getParameter("idSuatchieu"));

        suatChieuService.capNhatSuatChieu(idSuatchieu, idPhim, giaVe);

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        int idSuatchieu = Integer.parseInt(request.getParameter("idSuatchieu"));
        suatChieuService.xoaSuatChieuById(idSuatchieu);
    }
}
