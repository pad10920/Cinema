package com.example.cinema.mapper;

import com.example.cinema.model.PhimD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhimMapper {
    private static  PhimMapper phimMapper = null;
    public static PhimMapper khoiTao(){
        return phimMapper == null ? new PhimMapper() : phimMapper;
    }

    public PhimD phimDAOsangPhim(ResultSet phimRS, PhimD phimD){
        try {
            phimD.setIdPhim(phimRS.getInt(1));
            phimD.setTenPhim(phimRS.getString(2));
            phimD.setThoiLuong(phimRS.getInt(3));
            phimD.setMoTa(phimRS.getString(4));
            phimD.setQuocGia(phimRS.getString(5));
            phimD.setTrangThai(phimRS.getInt(6));
            phimD.setAnhPhim(phimRS.getString(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phimD;
    }
}
