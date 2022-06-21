package com.example.cinema.dao;

import com.example.cinema.mapper.PhongchieuMapper;
import com.example.cinema.model.PhongchieuD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongchieuDAOD {
    private static PhongchieuDAOD phongchieuDAOD = null;
    public static PhongchieuDAOD khoitao(){
        return phongchieuDAOD == null ? new PhongchieuDAOD() : phongchieuDAOD;
    }

    private PhongchieuMapper mapper = PhongchieuMapper.khoitao();

    public List<PhongchieuD> layListPhongChieuSanDung(int idRap, Date ngaychieu, Time thoigianbd, Time thoigiankt){
        List<PhongchieuD> phongchieuDList = new ArrayList<>();
        Connection connection = AbstractDAOD.getConnection();
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
                phongchieuDList.add(layPhongchieuById(idPhongchieu));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongchieuDList;
    }

    // lay phong chieu by id
    public PhongchieuD layPhongchieuById(int phongchieuId){
        PhongchieuD phongchieuD = new PhongchieuD();
        Connection connection = AbstractDAOD.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM phongchieu WHERE ID_PHONGCHIEU = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, phongchieuId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                phongchieuD = mapper.phongchieuDAOtoEntity(resultSet, phongchieuD);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongchieuD;
    }

    //lay so luong ghe cua phong
    public int laySoLuongGhe(int idPhong){
        int soluong = 0;
        Connection connection = AbstractDAOD.getConnection();
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
