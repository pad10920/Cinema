package com.example.cinema.dao;

import com.example.cinema.model.Phongchieu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GheDAO {
    private static GheDAO gheDAO = null;
    public static GheDAO khoitao(){
        return gheDAO == null ? new GheDAO() : gheDAO;
    }

    public void themGheChoShow(int soluongghe, int idSuatchieu){
        Connection connection = AbstractDAO.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO `ghe`( `GHE_SO`, `ID_SUATCHIEU`, `TRANG_THAI`)" +
                " VALUES (?, ?, 0)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            for(int i=1; i<=soluongghe; i++){
                preparedStatement.setInt(1, i);
                preparedStatement.setInt(2, idSuatchieu);
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
