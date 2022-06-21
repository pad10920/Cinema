package com.example.cinema.services;

import com.example.cinema.dao.TheLoaiDAOD;
import com.example.cinema.model.TheLoaiD;

import java.util.List;

public class TheLoaiService {
    // khoi tao the loai service
    private static TheLoaiService theLoaiService = null;
    public static TheLoaiService khoiTao(){
        return theLoaiService == null ? new TheLoaiService() : theLoaiService;
    }
    private TheLoaiDAOD theLoaiDAO = TheLoaiDAOD.khoiTaoTheLoaiDAO();
    public List<TheLoaiD> layListTheLoai(){
        return theLoaiDAO.layListTheloai();
    }
}
