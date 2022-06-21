package com.example.cinema.mapper;

import com.example.cinema.model.Suatchieu;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SuatchieuMapper {
    private static SuatchieuMapper mapper = null;
    public static SuatchieuMapper khoitao(){
        return mapper == null ? new SuatchieuMapper() : mapper;
    }

    public Suatchieu suatchieuDAOtoEntity(ResultSet rsSuatchieu, Suatchieu suatchieu){
        try {
            suatchieu.setIdSuatchieu(rsSuatchieu.getInt(1));
            suatchieu.setGiaVe(rsSuatchieu.getInt(2));
            suatchieu.setNgaychieu(rsSuatchieu.getDate(3));
            suatchieu.setThoigianBd(rsSuatchieu.getTime(4));
            suatchieu.setThoigianKt(rsSuatchieu.getTime(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suatchieu;
    }
}
