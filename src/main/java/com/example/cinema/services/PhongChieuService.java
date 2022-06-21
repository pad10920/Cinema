package com.example.cinema.services;

import com.example.cinema.dao.PhongchieuDAOD;
import com.example.cinema.dao.SuatchieuDAOD;
import com.example.cinema.model.PhongchieuD;

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

    SuatchieuDAOD suatchieuDAOD = SuatchieuDAOD.khoitao();
    PhongchieuDAOD phongchieuDAOD = PhongchieuDAOD.khoitao();

    public List<PhongchieuD> layListPhongchieuSanDung(String dateshow, String startTime, String endTime, int idRap){
        List<PhongchieuD> phongchieuDList = new ArrayList<>();
        Date ngaychieu = convertStringToDate(dateshow);
        Time thoigianBd = convertStringToTime(startTime);
        Time thoigianKt = convertStringToTime(endTime);
        return phongchieuDAOD.layListPhongChieuSanDung(idRap, ngaychieu, thoigianBd, thoigianKt);
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
