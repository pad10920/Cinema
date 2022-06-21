package com.example.cinema.services;

import com.example.cinema.dao.TheLoaiPhimDAO;

public class TheLoaiPhimService {
    private static TheLoaiService service = null;
    public static TheLoaiService khoiTao(){
        return service == null ? new TheLoaiService() : service;
    }

    private TheLoaiPhimDAO theLoaiPhimDAO = TheLoaiPhimDAO.khoiTao();
    public void luuTheLoai(int idPhim, int idTheLoai){
        theLoaiPhimDAO.luuTheLoai(idPhim, idTheLoai);
    }
}
