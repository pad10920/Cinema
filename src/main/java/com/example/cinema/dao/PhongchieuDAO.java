package com.example.cinema.dao;

import com.example.cinema.mapper.PhongchieuMapper;
import com.example.cinema.model.Phongchieu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongchieuDAO {
    private static PhongchieuDAO phongchieuDAO = null;
    public static PhongchieuDAO khoitao(){
        return phongchieuDAO == null ? new PhongchieuDAO() : phongchieuDAO;
    }

    private PhongchieuMapper mapper = PhongchieuMapper.khoitao();

    public List<Phongchieu> layListPhongChieuSanDung(int idRap, Date ngaychieu, Time thoigianbd, Time thoigiankt){
        List<Phongchieu> phongchieuList = new ArrayList<>();
        Connection connection = AbstractDAO.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT DISTINCT z.*\n" +
                "FROM (\n" +
                "        SELECT phongchieu.ID_PHONGCHIEU from suatchieu\n" +
                "        INNER JOIN phongchieu\n" +
                "            ON suatchieu.ID_PHONGCHIEU = phongchieu.ID_PHONGCHIEU\n" +
                "        INNER JOIN rap\n" +
                "            ON phongchieu.ID_RAP = rap.ID_RAP\n" +
                "        WHERE rap.ID_RAP = ? AND suatchieu.NGAY_CHIEU = ?\n" +
                "        AND \n" +
                "            (\n" +
                "                ? < suatchieu.THOI_GIAN_BD\n" +
                "                OR\n" +
                "                ? > suatchieu.THOI_GIAN_KT\n" +
                "\t\t\t)\n" +
                "    \tUNION\n" +
                "        SELECT phongchieu.ID_PHONGCHIEU from phongchieu\n" +
                "        INNER JOIN rap\n" +
                "            ON phongchieu.ID_RAP = rap.ID_RAP\n" +
                "        WHERE rap.ID_RAP = ? \n" +
                "    \t\tAND phongchieu.ID_PHONGCHIEU NOT IN (SELECT phongchieu.ID_PHONGCHIEU FROM phongchieu\n" +
                "                \t\t\t\t\t\t\t\tINNER JOIN suatchieu ON phongchieu.ID_PHONGCHIEU = suatchieu.ID_PHONGCHIEU\n" +
                "                                             \tWHERE suatchieu.NGAY_CHIEU = ?\n" +
                "            \t\t\t\t\t\t\t\t)\n" +
                "    ) as z;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idRap);
            preparedStatement.setDate(2, ngaychieu);
            preparedStatement.setTime(3, thoigiankt);
            preparedStatement.setTime(4, thoigianbd);
            preparedStatement.setInt(5, idRap);
            preparedStatement.setDate(6, ngaychieu);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idPhongchieu = resultSet.getInt(1);
                phongchieuList.add(layPhongchieuById(idPhongchieu));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongchieuList;
    }

    // lay phong chieu by id
    public Phongchieu layPhongchieuById(int phongchieuId){
        Phongchieu phongchieu = new Phongchieu();
        Connection connection = AbstractDAO.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM phongchieu WHERE ID_PHONGCHIEU = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, phongchieuId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                phongchieu = mapper.phongchieuDAOtoEntity(resultSet, phongchieu);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongchieu;
    }

    //lay so luong ghe cua phong
    public int laySoLuongGhe(int idPhong){
        int soluong = 0;
        Connection connection = AbstractDAO.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT SO_LUONG_GHE  FROM phongchieu WHERE ID_PHONGCHIEU = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idPhong);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                soluong = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soluong;
    }
}
