/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema.dao;

import com.example.cinema.mapper.UserMapper;
import com.example.cinema.model.User;

import javax.inject.Inject;
import java.sql.*;

import static com.example.cinema.dao.AbstractDAO.getConnection;

public class UserDAO {

    private static UserDAO userDAO = null;
    public static UserDAO khoiTaoUserDAO(){
        return userDAO == null ? new UserDAO() : userDAO;
    }

    UserMapper userMapper = UserMapper.khoiTaoUserMapper();
    private Connection connection = AbstractDAO.getConnection();
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public User layUserBangTkVaMk(String username, String password){
        String query = "SELECT * FROM user WHERE username = ? and password = ?";
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = userMapper.userDAOSangUser(resultSet, user);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public User layUserBangTk(String username){
        String query = "SELECT * FROM user WHERE username = ?";
        User user = null;
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = userMapper.userDAOSangUser(resultSet, user);
            }
            resultSet.close();
        }catch (SQLException e){
            System.out.println(e);
        }
        return user;
    }
    public User layUserBangEmail(String email){
        String query = "SELECT * FROM user WHERE email = ?";
        User user = null;
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = userMapper.userDAOSangUser(resultSet, user);
            }
            resultSet.close();
        }catch (SQLException e){
            System.out.println(e);
        }
        return user;
    }

    public void luuUser (User user){
        String query = "INSERT INTO user (`USERNAME`, `PASSWORD`, `HO_TEN`, `DIA_CHI`, `SDT`, `EMAIL`, `QUYEN`) " +
                "values (?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getHoTen());
            preparedStatement.setString(4, user.getDiaChi());
            preparedStatement.setString(5, user.getSdt());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getQuyen());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
