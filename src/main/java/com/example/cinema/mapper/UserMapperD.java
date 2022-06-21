package com.example.cinema.mapper;

import com.example.cinema.model.UserD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapperD {

    private static UserMapperD mapper = null;
    public static UserMapperD khoiTaoUserMapper(){
        return mapper == null ? new UserMapperD() : mapper;
    }

    public UserD userDAOSangUser(ResultSet userRs, UserD userD){
        userD = new UserD();
        try {
            userD.setIdUser(userRs.getInt(1));
            userD.setUsername(userRs.getString(2));
            userD.setPassword(userRs.getString(3));
            userD.setHoTen(userRs.getString(4));
            userD.setDiaChi(userRs.getString(5));
            userD.setSdt(userRs.getString(6));
            userD.setEmail(userRs.getString(7));
            userD.setQuyen(userRs.getString(8));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userD;
    }
}
