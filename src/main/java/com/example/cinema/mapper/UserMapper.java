package com.example.cinema.mapper;

import com.example.cinema.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    private static UserMapper mapper = null;
    public static UserMapper khoiTaoUserMapper(){
        return mapper == null ? new UserMapper() : mapper;
    }

    public User userDAOSangUser(ResultSet userRs, User user){
        user = new User();
        try {
            user.setIdUser(userRs.getInt(1));
            user.setUsername(userRs.getString(2));
            user.setPassword(userRs.getString(3));
            user.setHoTen(userRs.getString(4));
            user.setDiaChi(userRs.getString(5));
            user.setSdt(userRs.getString(6));
            user.setEmail(userRs.getString(7));
            user.setQuyen(userRs.getString(8));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
