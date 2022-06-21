package com.example.cinema.dao;

import com.example.cinema.mapper.SuatchieuMapper;
import com.example.cinema.model.SuatchieuD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SuatchieuDAOD {
    private static SuatchieuDAOD dao = null;
    public static SuatchieuDAOD khoitao(){
        return dao == null ? new SuatchieuDAOD() : dao;
    }

    private SuatchieuMapper mapper = SuatchieuMapper.khoitao();
    private PhimDAOD phimDAOD = PhimDAOD.khoiTao();

    public void themSuatChieu(SuatchieuD suatchieuD, int idPhim, int idPhong){
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement;
        String sql = "INSERT INTO `suatchieu`(`GIA_VE`, `NGAY_CHIEU`, `THOI_GIAN_BD`, `THOI_GIAN_KT`, `ID_PHIM`, `ID_PHONGCHIEU`) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, suatchieuD.getGiaVe());
            preparedStatement.setDate(2, suatchieuD.getNgaychieu());
            preparedStatement.setTime(3, suatchieuD.getThoigianBd());
            preparedStatement.setTime(4, suatchieuD.getThoigianKt());
            preparedStatement.setInt(5, idPhim);
            preparedStatement.setInt(6, idPhong);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int layNextIdSuatchieu(){
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int nextId = 0;
        String sql = "SELECT `auto_increment` FROM INFORMATION_SCHEMA.TABLES\n" +
                "WHERE table_name = 'suatchieu'";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                nextId = resultSet.getInt(1);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextId;
    }

    public List<SuatchieuD> layListByRapId(int rapId){
        List<SuatchieuD> suatchieuses = new ArrayList<>();
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM suatchieu \n" +
                "INNER JOIN phongchieu\n" +
                "\tON suatchieu.ID_PHIM = phongchieu.ID_PHONGCHIEU\n" +
                "INNER JOIN rap\n" +
                "\tON phongchieu.ID_RAP = rap.ID_RAP\n" +
                "WHERE rap.ID_RAP = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, rapId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                SuatchieuD suatchieuD = new SuatchieuD();
                suatchieuD = mapper.suatchieuDAOtoEntity(resultSet, suatchieuD);
                suatchieuD.setPhim(phimDAOD.layPhimById(resultSet.getInt(6)));
                suatchieuses.add(suatchieuD);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suatchieuses;
    }

    public SuatchieuD laySuatchieuById(int id){
        SuatchieuD suatchieuD = new SuatchieuD();
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM `suatchieu` WHERE ID_SUATCHIEU = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                suatchieuD = mapper.suatchieuDAOtoEntity(resultSet, suatchieuD);
                suatchieuD.setPhim(phimDAOD.layPhimById(resultSet.getInt(6)));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suatchieuD;
    }
    public void capNhatSuatChieu(int idSuatchieu, int idPhim, int giaVe){
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "UPDATE `suatchieu` SET `GIA_VE`=?, `ID_PHIM`=? WHERE ID_SUATCHIEU = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, giaVe);
            preparedStatement.setInt(2, idPhim);
            preparedStatement.setInt(3, idSuatchieu);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void xoaById(int idSuatchieu){
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM `suatchieu` WHERE ID_SUATCHIEU = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idSuatchieu);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
