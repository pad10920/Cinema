package com.example.cinema.mapper;

import com.example.cinema.model.Phim;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhimMapper {
    private static  PhimMapper phimMapper = null;
    public static PhimMapper khoiTao(){
        return phimMapper == null ? new PhimMapper() : phimMapper;
    }

    public Phim phimDAOsangPhim(ResultSet phimRS, Phim phim){
        try {
            phim.setIdPhim(phimRS.getInt(1));
            phim.setTenPhim(phimRS.getString(2));
            phim.setThoiLuong(phimRS.getInt(3));
            phim.setMoTa(phimRS.getString(4));
            phim.setQuocGia(phimRS.getString(5));
            phim.setTrangThai(phimRS.getInt(6));
            phim.setAnhPhim(phimRS.getString(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phim;
    }
}
