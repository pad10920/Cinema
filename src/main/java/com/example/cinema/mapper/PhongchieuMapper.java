package com.example.cinema.mapper;

import com.example.cinema.model.Phongchieu;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhongchieuMapper {
    private static PhongchieuMapper mapper = null;
    public static PhongchieuMapper khoitao(){
        return mapper == null ? new PhongchieuMapper() : mapper;
    }

    public Phongchieu phongchieuDAOtoEntity(ResultSet phongchieuRs, Phongchieu phongchieu){
        try {
            phongchieu.setIdPhongchieu(phongchieuRs.getInt(1));
            phongchieu.setTenPhong(phongchieuRs.getString(2));
            phongchieu.setSoLuongGhe(phongchieuRs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongchieu;
    }
}
