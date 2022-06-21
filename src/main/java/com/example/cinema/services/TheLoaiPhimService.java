package com.example.cinema.services;

import com.example.cinema.dao.TheLoaiPhimDAOD;

public class TheLoaiPhimService {
    private static TheLoaiService service = null;
    public static TheLoaiService khoiTao(){
        return service == null ? new TheLoaiService() : service;
    }

    private TheLoaiPhimDAOD theLoaiPhimDAOD = TheLoaiPhimDAOD.khoiTao();
    public void luuTheLoai(int idPhim, int idTheLoai){
        theLoaiPhimDAOD.luuTheLoai(idPhim, idTheLoai);
    }
}
