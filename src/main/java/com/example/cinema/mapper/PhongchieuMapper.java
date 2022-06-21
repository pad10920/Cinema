package com.example.cinema.mapper;

import com.example.cinema.model.PhongchieuD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhongchieuMapper {
    private static PhongchieuMapper mapper = null;
    public static PhongchieuMapper khoitao(){
        return mapper == null ? new PhongchieuMapper() : mapper;
    }

    public PhongchieuD phongchieuDAOtoEntity(ResultSet phongchieuRs, PhongchieuD phongchieuD){
        try {
            phongchieuD.setIdPhongchieu(phongchieuRs.getInt(1));
            phongchieuD.setTenPhong(phongchieuRs.getString(2));
            phongchieuD.setSoLuongGhe(phongchieuRs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongchieuD;
    }
}
