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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
