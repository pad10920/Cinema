package com.example.cinema.services;

import com.example.cinema.dao.GheDAOD;
import com.example.cinema.dao.PhongchieuDAOD;
import com.example.cinema.dao.SuatchieuDAOD;
import com.example.cinema.model.SuatchieuD;

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

    private SuatchieuDAOD suatchieuDAOD = SuatchieuDAOD.khoitao();
    private PhongchieuDAOD phongchieuDAOD = PhongchieuDAOD.khoitao();
    private GheDAOD gheDAOD = GheDAOD.khoitao();

    public void themSuatChieu(SuatchieuD suatchieuD, int idPhim, String phongchieu){
        for (String s: phongchieu.trim().split(",")){
            int idPhongchieu = Integer.parseInt(s.trim());
            int nextIdSuatchieu = suatchieuDAOD.layNextIdSuatchieu();
            int soluongghe = phongchieuDAOD.laySoLuongGhe(idPhongchieu);
            suatchieuDAOD.themSuatChieu(suatchieuD, idPhim, idPhongchieu);
            gheDAOD.themGheChoShow(soluongghe, nextIdSuatchieu);
        }
    }

    public List<SuatchieuD> layListSuatchieuByrap(int idRap){
        List<SuatchieuD> suatchieuDList = new ArrayList<>();
        suatchieuDList = suatchieuDAOD.layListByRapId(idRap);
        return suatchieuDList;
    }

    public SuatchieuD laySuatChieuById(int suatChieuId){
        SuatchieuD suatchieuD = new SuatchieuD();
        suatchieuD = suatchieuDAOD.laySuatchieuById(suatChieuId);
        return suatchieuD;
    }

    public SuatchieuD taoSuatChieuByInfo(String SNgaychieu, String Sthoigianbd,
                                         String Sthoigiankt, int giave){
        SuatchieuD suatchieuD = new SuatchieuD();
        Date ngaychieu = convertStringToDate(SNgaychieu);
        Time thoigianbd = convertStringToTime(Sthoigianbd);
        Time thoigiankt = convertStringToTime(Sthoigiankt);

        suatchieuD.setGiaVe(giave);
        suatchieuD.setNgaychieu(ngaychieu);
        suatchieuD.setThoigianBd(thoigianbd);
        suatchieuD.setThoigianKt(thoigiankt);

        return suatchieuD;
    }

    public void capNhatSuatChieu(int idSuatchieu, int idPhim, int giaVe){
        suatchieuDAOD.capNhatSuatChieu(idSuatchieu, idPhim, giaVe);
    }
    public void xoaSuatChieuById(int id){
        suatchieuDAOD.xoaById(id);
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
