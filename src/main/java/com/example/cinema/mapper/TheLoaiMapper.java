package com.example.cinema.mapper;

import com.example.cinema.model.TheLoai;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TheLoaiMapper {
    private static TheLoaiMapper theLoaiMapper = null;
    public static TheLoaiMapper khoiTaoTheLoaiMapper(){
        return theLoaiMapper == null ? new TheLoaiMapper() : theLoaiMapper;
    }

    public TheLoai theLoaiDaoSangTheLoai(ResultSet theLoaiRS, TheLoai theLoai){
        try {
            theLoai.setIdTheloai(theLoaiRS.getInt(1));
            theLoai.setTenLoai(theLoaiRS.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theLoai;
    }
}
