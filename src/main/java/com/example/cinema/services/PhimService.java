package com.example.cinema.services;

import com.example.cinema.dao.PhimDAO;
import com.example.cinema.dao.TheLoaiPhimDAO;
import com.example.cinema.model.Phim;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PhimService {
    private static PhimService service = null;
    public static PhimService khoiTao(){
        return service == null ? new PhimService() : service;
    }

    private PhimDAO phimDAO = PhimDAO.khoiTao();
    private TheLoaiPhimDAO theLoaiPhimDAO = TheLoaiPhimDAO.khoiTao();

    public int themPhim(Phim phim, Part anhPhim, String theLoai, String location){
        int nextId = phimDAO.layNextIdPhim();
        String tenAnh = "";
        // tao ten cho hinh anh
        for (String s : phim.getTenPhim().split(" ")){
            String kyTuDau = String.valueOf(s.charAt(0));
            if (kyTuDau.compareToIgnoreCase("đ") != 0)
                tenAnh += s.charAt(0);
        }

        tenAnh = (tenAnh + nextId + ".jpg").toUpperCase();
        phim.setAnhPhim(tenAnh);

        location += tenAnh;
        try {
            anhPhim.write(location);
        } catch (IOException e) {
            e.printStackTrace();
        }
        phimDAO.insert(phim);
        for (String s: theLoai.trim().split(",")){
            int idTheLoai = Integer.parseInt(s.trim());
            theLoaiPhimDAO.luuTheLoai(nextId, idTheLoai);
        }
        return 1;
    }

    public void capNhapPhim(Phim phim, String theLoai){
        System.out.println(phim);
        phimDAO.capNhapPhim(phim);
        theLoaiPhimDAO.xoaTheLoaiByIdPhim(phim.getIdPhim());

        for(String s: theLoai.trim().split(",")){
            int idTheloai = Integer.parseInt(s.trim());
            theLoaiPhimDAO.luuTheLoai(phim.getIdPhim(), idTheloai);
        }
    }

    public List<Phim> layListPhimByTen(String key){
        return phimDAO.layListPhimByTen(key);
    }
    public List<Phim> layListPhim(){
        return phimDAO.layListPhim();
    }

    public Phim layPhimById(int idPhim){
        Phim phim = phimDAO.layPhimById(idPhim);
        return phim;
    }

}
