package com.example.cinema.services;

import com.example.cinema.dao.TheLoaiDAO;
import com.example.cinema.model.TheLoai;

import java.util.List;

public class TheLoaiService {
    // khoi tao the loai service
    private static TheLoaiService theLoaiService = null;
    public static TheLoaiService khoiTao(){
        return theLoaiService == null ? new TheLoaiService() : theLoaiService;
    }
    private TheLoaiDAO theLoaiDAO = TheLoaiDAO.khoiTaoTheLoaiDAO();
    public List<TheLoai> layListTheLoai(){
        return theLoaiDAO.layListTheloai();
    }
}
