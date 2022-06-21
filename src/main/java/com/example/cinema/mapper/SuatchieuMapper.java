package com.example.cinema.mapper;

import com.example.cinema.model.SuatchieuD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SuatchieuMapper {
    private static SuatchieuMapper mapper = null;
    public static SuatchieuMapper khoitao(){
        return mapper == null ? new SuatchieuMapper() : mapper;
    }

    public SuatchieuD suatchieuDAOtoEntity(ResultSet rsSuatchieu, SuatchieuD suatchieuD){
        try {
            suatchieuD.setIdSuatchieu(rsSuatchieu.getInt(1));
            suatchieuD.setGiaVe(rsSuatchieu.getInt(2));
            suatchieuD.setNgaychieu(rsSuatchieu.getDate(3));
            suatchieuD.setThoigianBd(rsSuatchieu.getTime(4));
            suatchieuD.setThoigianKt(rsSuatchieu.getTime(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suatchieuD;
    }
}
