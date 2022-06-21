package com.example.cinema.dao;

import com.example.cinema.mapper.PhongchieuMapper;
import com.example.cinema.mapper.RapMapper;
import com.example.cinema.model.Rap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RapDAO {
    private static RapDAO rapDAO = null;
    public static RapDAO khoitao(){
        return rapDAO == null ? new RapDAO() : rapDAO;
    }

    private RapMapper rapMapper = RapMapper.khoitao();
    private PhongchieuMapper phongchieuMapper = PhongchieuMapper.khoitao();

    public List<Rap> layListRap(){
        Connection connection = AbstractDAO.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM rap";
        List<Rap> raps = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Rap rap = new Rap();
                rap = rapMapper.rapDAOtoEntity(resultSet, rap);
                raps.add(rap);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return raps;
    }
}
