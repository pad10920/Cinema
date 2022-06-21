/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema.dao;

import com.example.cinema.mapper.TheLoaiMapper;
import com.example.cinema.model.TheLoaiD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuong
 */
public class TheLoaiDAOD extends AbstractDAOD {

    private static TheLoaiDAOD theLoaiDAO = null;
    public static TheLoaiDAOD khoiTaoTheLoaiDAO(){
        return theLoaiDAO == null ? new TheLoaiDAOD() : theLoaiDAO;
    }

    private TheLoaiMapper theLoaiMapper = TheLoaiMapper.khoiTaoTheLoaiMapper();

    public static List<String> getTheLoaiByIDPhim(int id){
        List<String> list = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
       
        try {
            connection = getConnection();
            String sql = "SELECT TEN_LOAI FROM theloai\n" +
                        "INNER JOIN theloaiphim\n" +
                        "ON theloai.ID_THELOAI = theloaiphim.ID_THELOAIPHIM\n" +
                        "INNER JOIN phim\n" +
                        "ON phim.ID_PHIM = theloaiphim.ID_PHIM\n" +
                        "WHERE phim.ID_PHIM = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            while(rs.next()){
                list.add(rs.getString("TEN_LOAI"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<TheLoaiD> layListTheloai(){
        List<TheLoaiD> result = new ArrayList<>();
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String query = "SELECT * FROM theloai;";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                TheLoaiD theLoaiD = new TheLoaiD();
                theLoaiD = theLoaiMapper.theLoaiDaoSangTheLoai(resultSet, theLoaiD);
                result.add(theLoaiD);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
