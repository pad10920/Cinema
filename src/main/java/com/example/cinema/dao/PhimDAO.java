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
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.cinema.mapper.PhimMapper;
import com.example.cinema.model.Phim;

import static com.example.cinema.dao.AbstractDAO.getConnection;


/**
 *
 * @author cuong
 */
public class PhimDAO {
    private static PhimDAO phimDAO = null;
    public static PhimDAO khoiTao(){
        return phimDAO == null ? new PhimDAO() : phimDAO;
    }
    private PhimMapper phimMapper = PhimMapper.khoiTao();
    private TheLoaiPhimDAO theLoaiPhimDAO = TheLoaiPhimDAO.khoiTao();
    public List<Phim> findAll(){

        List<Phim> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            connection = getConnection();
            String sql = "select ID_PHIM from phim";
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                Phim phim = new Phim();
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
    public Phim getPhimById(int id){
        Phim phim = new Phim();
        
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
                phim.setId(rs.getInt("ID_PHIM"));
                phim.setTenPhim(rs.getString("TEN_PHIM"));
                phim.setThoiLuong(rs.getInt("THOI_LUONG"));
                phim.setMoTa(rs.getString("MO_TA"));
                phim.setQuocGia(rs.getString("QUOC_GIA"));
                phim.setAnhPhim(rs.getString("ANH_PHIM"));
                phim.setTrangThai(rs.getInt("TRANG_THAI"));
//                return phim;
                
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
            return phim;
            
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
    public List<Phim> getPhimByLoai(int loai){
        List<Phim> list = findAll();
        List<Phim> listLoai = new ArrayList<>();
        for(Phim phim : list){
            if(phim.getTrangThai() == loai){
                listLoai.add(phim);
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
    public void insert(Phim phim){
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = getConnection();
            String sql = "INSERT INTO `phim`(`TEN_PHIM`, `THOI_LUONG`, `MO_TA`, `QUOC_GIA`, `ANH_PHIM`, `TRANG_THAI`) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, phim.getTenPhim());
            pstm.setInt(2, phim.getThoiLuong());
            pstm.setString(3, phim.getMoTa());
            pstm.setString(4, phim.getQuocGia());
            pstm.setString(5, phim.getAnhPhim());
            pstm.setInt(6, phim.getTrangThai());
            
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
        Connection connection = AbstractDAO.getConnection();
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
    public List<Phim> layListPhim(){
        Connection connection = AbstractDAO.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Phim> phimList = new ArrayList<>();
        String sql = "SELECT * FROM phim";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Phim phim = new Phim();
                phim = phimMapper.phimDAOsangPhim(resultSet, phim);
                phim.setTheLoais(theLoaiPhimDAO.layListTheLoaiByPhimId(phim.getIdPhim()));
                phimList.add(phim);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phimList;
    }
    // lay phim theo id
    public Phim layPhimById(int idPhim){
        Connection connection = AbstractDAO.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM phim WHERE ID_PHIM = ?";
        Phim phim = new Phim();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idPhim);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                phim = phimMapper.phimDAOsangPhim(resultSet, phim);
                phim.setTheLoais(theLoaiPhimDAO.layListTheLoaiByPhimId(idPhim));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phim;
    }

    // cập nhật phim
    public void capNhapPhim(Phim phim){
        Connection connection = AbstractDAO.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE `phim` SET `TEN_PHIM`= ?,`THOI_LUONG`= ?," +
                "`MO_TA`= ?,`QUOC_GIA`=?,`TRANG_THAI`= ? " +
                "WHERE ID_PHIM = ? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phim.getTenPhim());
            preparedStatement.setInt(2, phim.getThoiLuong());
            preparedStatement.setString(3, phim.getMoTa());
            preparedStatement.setString(4, phim.getQuocGia());
            preparedStatement.setInt(5, phim.getTrangThai());
            preparedStatement.setInt(6, phim.getIdPhim());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // tìm phim bằng tên
    public List<Phim> layListPhimByTen(String key){
        Connection connection = AbstractDAO.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Phim> phimList = new ArrayList<>();
        String sql = "SELECT * FROM `phim` WHERE TEN_PHIM LIKE ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%"+key+"%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Phim phim = new Phim();
                phim = phimMapper.phimDAOsangPhim(resultSet, phim);
                phim.setTheLoais(theLoaiPhimDAO.layListTheLoaiByPhimId(phim.getIdPhim()));
                phimList.add(phim);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phimList;
    }
}
