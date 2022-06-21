package com.example.cinema.services;

import com.example.cinema.dao.PhimDAOD;
import com.example.cinema.dao.TheLoaiPhimDAOD;
import com.example.cinema.model.PhimD;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

public class PhimService {
    private static PhimService service = null;
    public static PhimService khoiTao(){
        return service == null ? new PhimService() : service;
    }

    private PhimDAOD phimDAOD = PhimDAOD.khoiTao();
    private TheLoaiPhimDAOD theLoaiPhimDAOD = TheLoaiPhimDAOD.khoiTao();

    public int themPhim(PhimD phimD, Part anhPhim, String theLoai, String location){
        int nextId = phimDAOD.layNextIdPhim();
        String tenAnh = "";
        // tao ten cho hinh anh
        for (String s : phimD.getTenPhim().split(" ")){
            String kyTuDau = String.valueOf(s.charAt(0));
            if (kyTuDau.compareToIgnoreCase("đ") != 0)
                tenAnh += s.charAt(0);
        }

        tenAnh = (tenAnh + nextId + ".jpg").toUpperCase();
        phimD.setAnhPhim(tenAnh);

        location += tenAnh;
        try {
            anhPhim.write(location);
        } catch (IOException e) {
            e.printStackTrace();
        }
        phimDAOD.insert(phimD);
        for (String s: theLoai.trim().split(",")){
            int idTheLoai = Integer.parseInt(s.trim());
            theLoaiPhimDAOD.luuTheLoai(nextId, idTheLoai);
        }
        return 1;
    }

    public void capNhapPhim(PhimD phimD, String theLoai){
        System.out.println(phimD);
        phimDAOD.capNhapPhim(phimD);
        theLoaiPhimDAOD.xoaTheLoaiByIdPhim(phimD.getIdPhim());

        for(String s: theLoai.trim().split(",")){
            int idTheloai = Integer.parseInt(s.trim());
            theLoaiPhimDAOD.luuTheLoai(phimD.getIdPhim(), idTheloai);
        }
    }

    public List<PhimD> layListPhimByTen(String key){
        return phimDAOD.layListPhimByTen(key);
    }
    public List<PhimD> layListPhim(){
        return phimDAOD.layListPhim();
    }

    public PhimD layPhimById(int idPhim){
        PhimD phimD = phimDAOD.layPhimById(idPhim);
        return phimD;
    }

}
