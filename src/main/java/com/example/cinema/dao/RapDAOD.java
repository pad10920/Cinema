package com.example.cinema.dao;

import com.example.cinema.mapper.PhongchieuMapper;
import com.example.cinema.mapper.RapMapper;
import com.example.cinema.model.RapD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RapDAOD {
    private static RapDAOD rapDAOD = null;
    public static RapDAOD khoitao(){
        return rapDAOD == null ? new RapDAOD() : rapDAOD;
    }

    private RapMapper rapMapper = RapMapper.khoitao();
    private PhongchieuMapper phongchieuMapper = PhongchieuMapper.khoitao();

    public List<RapD> layListRap(){
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM rap";
        List<RapD> rapDS = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                RapD rapD = new RapD();
                rapD = rapMapper.rapDAOtoEntity(resultSet, rapD);
                rapDS.add(rapD);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rapDS;
    }
}
