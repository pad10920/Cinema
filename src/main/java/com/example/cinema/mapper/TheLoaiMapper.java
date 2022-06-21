package com.example.cinema.mapper;

import com.example.cinema.model.TheLoaiD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TheLoaiMapper {
    private static TheLoaiMapper theLoaiMapper = null;
    public static TheLoaiMapper khoiTaoTheLoaiMapper(){
        return theLoaiMapper == null ? new TheLoaiMapper() : theLoaiMapper;
    }

    public TheLoaiD theLoaiDaoSangTheLoai(ResultSet theLoaiRS, TheLoaiD theLoaiD){
        try {
            theLoaiD.setIdTheloai(theLoaiRS.getInt(1));
            theLoaiD.setTenLoai(theLoaiRS.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theLoaiD;
    }
}
