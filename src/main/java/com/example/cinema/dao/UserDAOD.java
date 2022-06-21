/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema.dao;

import com.example.cinema.mapper.UserMapperD;
import com.example.cinema.model.UserD;

import java.sql.*;

public class UserDAOD {

    private static UserDAOD userDAOD = null;
    public static UserDAOD khoiTaoUserDAO(){
        return userDAOD == null ? new UserDAOD() : userDAOD;
    }

    UserMapperD userMapperD = UserMapperD.khoiTaoUserMapper();
    private Connection connection = AbstractDAOD.getConnection();
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public UserD layUserBangTkVaMk(String username, String password){
        String query = "SELECT * FROM user WHERE username = ? and password = ?";
        UserD userD = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                userD = userMapperD.userDAOSangUser(resultSet, userD);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userD;
    }
    public UserD layUserBangTk(String username){
        String query = "SELECT * FROM user WHERE username = ?";
        UserD userD = null;
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                userD = userMapperD.userDAOSangUser(resultSet, userD);
            }
            resultSet.close();
        }catch (SQLException e){
            System.out.println(e);
        }
        return userD;
    }
    public UserD layUserBangEmail(String email){
        String query = "SELECT * FROM user WHERE email = ?";
        UserD userD = null;
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                userD = userMapperD.userDAOSangUser(resultSet, userD);
            }
            resultSet.close();
        }catch (SQLException e){
            System.out.println(e);
        }
        return userD;
    }

    public void luuUser (UserD userD){
        String query = "INSERT INTO user (`USERNAME`, `PASSWORD`, `HO_TEN`, `DIA_CHI`, `SDT`, `EMAIL`, `QUYEN`) " +
                "values (?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userD.getUsername());
            preparedStatement.setString(2, userD.getPassword());
            preparedStatement.setString(3, userD.getHoTen());
            preparedStatement.setString(4, userD.getDiaChi());
            preparedStatement.setString(5, userD.getSdt());
            preparedStatement.setString(6, userD.getEmail());
            preparedStatement.setString(7, userD.getQuyen());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
