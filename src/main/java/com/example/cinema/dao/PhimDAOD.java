/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.cinema.mapper.PhimMapper;
import com.example.cinema.model.PhimD;

import static com.example.cinema.dao.AbstractDAOD.getConnection;


/**
 *
 * @author cuong
 */
public class PhimDAOD {
    private static PhimDAOD phimDAOD = null;
    public static PhimDAOD khoiTao(){
        return phimDAOD == null ? new PhimDAOD() : phimDAOD;
    }
    private PhimMapper phimMapper = PhimMapper.khoiTao();
    private TheLoaiPhimDAOD theLoaiPhimDAOD = TheLoaiPhimDAOD.khoiTao();
    public List<PhimD> findAll(){

        List<PhimD> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            connection = getConnection();
            String sql = "select ID_PHIM from phim";
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                PhimD phimD = new PhimD();
                int id = rs.getInt("ID_PHIM");
                list.add(getPhimById(id));
                
                
                
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(connection != null){
                    connection.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(rs != null){
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
        return null;

    }
    public PhimD getPhimById(int id){
        PhimD phimD = new PhimD();
        
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        try {
            connection = getConnection();
            String sql = "SELECT * FROM `phim` WHERE ID_PHIM = ?";

            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            while(rs.next()){
                phimD.setId(rs.getInt("ID_PHIM"));
                phimD.setTenPhim(rs.getString("TEN_PHIM"));
                phimD.setThoiLuong(rs.getInt("THOI_LUONG"));
                phimD.setMoTa(rs.getString("MO_TA"));
                phimD.setQuocGia(rs.getString("QUOC_GIA"));
                phimD.setAnhPhim(rs.getString("ANH_PHIM"));
                phimD.setTrangThai(rs.getInt("TRANG_THAI"));
//                return phimD;
                
            }
            String sql1 = "SELECT TEN_LOAI from theloai, theloaiphim, phim WHERE\n" +
                            " phim.ID_PHIM = theloaiphim.ID_PHIM\n" +
                            "AND theloaiphim.ID_THELOAI = theloai.ID_THELOAI\n" +
                            "AND phim.ID_PHIM = ?;";
            pstm = connection.prepareStatement(sql1);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            List<String> listTheLoai = new ArrayList<>();
            while(rs.next()){
                listTheLoai.add(rs.getString("TEN_LOAI"));
               
            }
            return phimD;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(connection != null){
                    connection.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(rs != null){
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
        return null;

    }
    public List<PhimD> getPhimByLoai(int loai){
        List<PhimD> list = findAll();
        List<PhimD> listLoai = new ArrayList<>();
        for(PhimD phimD : list){
            if(phimD.getTrangThai() == loai){
                listLoai.add(phimD);
            }
        }
        return listLoai;
    }
    
    
    public int getLastIDPhim(){
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int lastID = 0;
        try {
            connection = getConnection();
            String sql = "SELECT ID_PHIM FROM `phim` order by ID_PHIM DESC LIMIT 1";
            pstm = connection.prepareStatement(sql);
            
            
            rs = pstm.executeQuery();
            while(rs.next()){
                lastID = rs.getInt("ID_PHIM");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(connection != null){
                    connection.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(rs != null){
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
        return lastID + 1;
    }
    public void insert(PhimD phimD){
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = getConnection();
            String sql = "INSERT INTO `phim`(`TEN_PHIM`, `THOI_LUONG`, `MO_TA`, `QUOC_GIA`, `ANH_PHIM`, `TRANG_THAI`) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, phimD.getTenPhim());
            pstm.setInt(2, phimD.getThoiLuong());
            pstm.setString(3, phimD.getMoTa());
            pstm.setString(4, phimD.getQuocGia());
            pstm.setString(5, phimD.getAnhPhim());
            pstm.setInt(6, phimD.getTrangThai());
            
            pstm.executeUpdate();
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(connection != null){
                    connection.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
        
    }

    public int layNextIdPhim(){
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int nextId = 0;
        String sql = "SELECT `auto_increment` FROM INFORMATION_SCHEMA.TABLES\n" +
                "WHERE table_name = 'phim'";
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

    public void deleteById(int id){
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = getConnection();
            String sql = "DELETE FROM `phim` WHERE ID = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(connection != null){
                    connection.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
    }

    // lay list phim
    public List<PhimD> layListPhim(){
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<PhimD> phimDList = new ArrayList<>();
        String sql = "SELECT * FROM phim";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                PhimD phimD = new PhimD();
                phimD = phimMapper.phimDAOsangPhim(resultSet, phimD);
                phimD.setTheLoais(theLoaiPhimDAOD.layListTheLoaiByPhimId(phimD.getIdPhim()));
                phimDList.add(phimD);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phimDList;
    }
    // lay phim theo id
    public PhimD layPhimById(int idPhim){
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM phim WHERE ID_PHIM = ?";
        PhimD phimD = new PhimD();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idPhim);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                phimD = phimMapper.phimDAOsangPhim(resultSet, phimD);
                phimD.setTheLoais(theLoaiPhimDAOD.layListTheLoaiByPhimId(idPhim));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phimD;
    }

    // cập nhật phimD
    public void capNhapPhim(PhimD phimD){
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE `phim` SET `TEN_PHIM`= ?,`THOI_LUONG`= ?," +
                "`MO_TA`= ?,`QUOC_GIA`=?,`TRANG_THAI`= ? " +
                "WHERE ID_PHIM = ? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phimD.getTenPhim());
            preparedStatement.setInt(2, phimD.getThoiLuong());
            preparedStatement.setString(3, phimD.getMoTa());
            preparedStatement.setString(4, phimD.getQuocGia());
            preparedStatement.setInt(5, phimD.getTrangThai());
            preparedStatement.setInt(6, phimD.getIdPhim());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // tìm phim bằng tên
    public List<PhimD> layListPhimByTen(String key){
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<PhimD> phimDList = new ArrayList<>();
        String sql = "SELECT * FROM `phim` WHERE TEN_PHIM LIKE ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%"+key+"%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                PhimD phimD = new PhimD();
                phimD = phimMapper.phimDAOsangPhim(resultSet, phimD);
                phimD.setTheLoais(theLoaiPhimDAOD.layListTheLoaiByPhimId(phimD.getIdPhim()));
                phimDList.add(phimD);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phimDList;
    }
}
