package com.example.cinema.dao;

import com.example.cinema.mapper.TheLoaiMapper;
import com.example.cinema.model.TheLoaiD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheLoaiPhimDAOD {
    private static TheLoaiPhimDAOD theLoaiPhimDAOD = null;
    public static TheLoaiPhimDAOD khoiTao(){
        return theLoaiPhimDAOD == null ? new TheLoaiPhimDAOD() : theLoaiPhimDAOD;
    }

    private TheLoaiMapper theLoaiMapper = TheLoaiMapper.khoiTaoTheLoaiMapper();

    public void luuTheLoai(int idPhim, int idTheLoai){
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO theloaiphim (`ID_PHIM`, `ID_THELOAI`) " +
                "VALUES (?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idPhim);
            preparedStatement.setInt(2, idTheLoai);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<TheLoaiD> layListTheLoaiByPhimId(int phimId){
        List<TheLoaiD> loaiList = new ArrayList<>();
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM theloai \n" +
                "INNER JOIN theloaiphim\n" +
                "ON theloai.ID_THELOAI = theloaiphim.ID_THELOAI\n" +
                "WHERE theloaiphim.ID_PHIM = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, phimId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                loaiList.add(theLoaiMapper.theLoaiDaoSangTheLoai(resultSet, new TheLoaiD()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loaiList;
    }

    public void xoaTheLoaiByIdPhim(int idPhim){
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM `theloaiphim` WHERE ID_PHIM = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idPhim);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
