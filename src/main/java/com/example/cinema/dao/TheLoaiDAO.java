/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuong
 */
public class TheLoaiDAO extends AbstractDAO{
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
}
