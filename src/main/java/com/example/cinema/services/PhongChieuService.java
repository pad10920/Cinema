package com.example.cinema.services;

import com.example.cinema.dao.PhongchieuDAO;
import com.example.cinema.dao.SuatchieuDAO;
import com.example.cinema.model.Phongchieu;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PhongChieuService {
    private static PhongChieuService service = null;
    public static PhongChieuService khoitao(){
        return service == null ? new PhongChieuService() : service;
    }

    SuatchieuDAO suatchieuDAO = SuatchieuDAO.khoitao();
    PhongchieuDAO phongchieuDAO = PhongchieuDAO.khoitao();

    public List<Phongchieu> layListPhongchieuSanDung(String dateshow, String startTime, String endTime, int idRap){
        List<Phongchieu> phongchieuList = new ArrayList<>();
        Date ngaychieu = convertStringToDate(dateshow);
        Time thoigianBd = convertStringToTime(startTime);
        Time thoigianKt = convertStringToTime(endTime);
        return phongchieuDAO.layListPhongChieuSanDung(idRap, ngaychieu, thoigianBd, thoigianKt);
    }

    private Date convertStringToDate(String dateStr){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new java.sql.Date(date.getTime());
    }

    private Time convertStringToTime(String sTime){
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        java.util.Date time = null;
        try {
            time = format.parse(sTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new java.sql.Time(time.getTime());
    }
}
