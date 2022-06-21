package com.example.cinema.services;

import com.example.cinema.dao.GheDAO;
import com.example.cinema.dao.PhongchieuDAO;
import com.example.cinema.dao.SuatchieuDAO;
import com.example.cinema.model.Suatchieu;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SuatChieuService {
    private static SuatChieuService service = null;
    public static SuatChieuService khoitao(){
        return service == null ? new SuatChieuService() : service;
    }

    private SuatchieuDAO suatchieuDAO = SuatchieuDAO.khoitao();
    private PhongchieuDAO phongchieuDAO = PhongchieuDAO.khoitao();
    private GheDAO gheDAO = GheDAO.khoitao();

    public void themSuatChieu(Suatchieu suatchieu, int idPhim, String phongchieu){
        for (String s: phongchieu.trim().split(",")){
            int idPhongchieu = Integer.parseInt(s.trim());
            int nextIdSuatchieu = suatchieuDAO.layNextIdSuatchieu();
            int soluongghe = phongchieuDAO.laySoLuongGhe(idPhongchieu);
            suatchieuDAO.themSuatChieu(suatchieu, idPhim, idPhongchieu);
            gheDAO.themGheChoShow(soluongghe, nextIdSuatchieu);
        }
    }

    public List<Suatchieu> layListSuatchieuByrap(int idRap){
        List<Suatchieu> suatchieuList = new ArrayList<>();
        suatchieuList = suatchieuDAO.layListByRapId(idRap);
        return suatchieuList;
    }

    public Suatchieu laySuatChieuById(int suatChieuId){
        Suatchieu suatchieu = new Suatchieu();
        suatchieu = suatchieuDAO.laySuatchieuById(suatChieuId);
        return suatchieu;
    }

    public Suatchieu taoSuatChieuByInfo(String SNgaychieu, String Sthoigianbd,
                                        String Sthoigiankt, int giave){
        Suatchieu suatchieu = new Suatchieu();
        Date ngaychieu = convertStringToDate(SNgaychieu);
        Time thoigianbd = convertStringToTime(Sthoigianbd);
        Time thoigiankt = convertStringToTime(Sthoigiankt);

        suatchieu.setGiaVe(giave);
        suatchieu.setNgaychieu(ngaychieu);
        suatchieu.setThoigianBd(thoigianbd);
        suatchieu.setThoigianKt(thoigiankt);

        return suatchieu;
    }

    public void capNhatSuatChieu(int idSuatchieu, int idPhim, int giaVe){
        suatchieuDAO.capNhatSuatChieu(idSuatchieu, idPhim, giaVe);
    }
    public void xoaSuatChieuById(int id){
        suatchieuDAO.xoaById(id);
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
