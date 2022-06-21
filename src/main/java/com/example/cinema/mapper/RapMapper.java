package com.example.cinema.mapper;

import com.example.cinema.model.Rap;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RapMapper {
    private static RapMapper rapMapper = null;
    public static RapMapper khoitao(){
        return rapMapper == null ? new RapMapper() : rapMapper;
    }
    public Rap rapDAOtoEntity(ResultSet rapRs, Rap rap){
        try {
            rap.setIdRap(rapRs.getInt(1));
            rap.setTenRap(rapRs.getString(2));
            rap.setDiaChi(rapRs.getString(3));
            rap.setThongTin(rapRs.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rap;
    }
}
