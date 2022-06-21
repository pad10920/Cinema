package com.example.cinema.mapper;

import com.example.cinema.model.RapD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RapMapper {
    private static RapMapper rapMapper = null;
    public static RapMapper khoitao(){
        return rapMapper == null ? new RapMapper() : rapMapper;
    }
    public RapD rapDAOtoEntity(ResultSet rapRs, RapD rapD){
        try {
            rapD.setIdRap(rapRs.getInt(1));
            rapD.setTenRap(rapRs.getString(2));
            rapD.setDiaChi(rapRs.getString(3));
            rapD.setThongTin(rapRs.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rapD;
    }
}
