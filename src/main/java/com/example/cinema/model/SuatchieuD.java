package com.example.cinema.model;

import java.sql.Date;
import java.sql.Time;

public class SuatchieuD {
    private int IdSuatchieu;
    private int giaVe;
    private Date ngaychieu;
    private Time thoigianBd;
    private Time thoigianKt;
    private PhimD phimD;
    private PhongchieuD phongchieuD;

    public SuatchieuD() {
    }

    @Override
    public String toString() {
        return "SuatchieuD{" +
                "IdSuatchieu=" + IdSuatchieu +
                ", giaVe=" + giaVe +
                ", ngaychieu=" + ngaychieu +
                ", thoigianBd=" + thoigianBd +
                ", thoigianKt=" + thoigianKt +
                ", phimD=" + phimD +
                ", phongchieuD=" + phongchieuD +
                '}';
    }

    public int getIdSuatchieu() {
        return IdSuatchieu;
    }

    public void setIdSuatchieu(int idSuatchieu) {
        IdSuatchieu = idSuatchieu;
    }

    public int getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;
    }

    public Date getNgaychieu() {
        return ngaychieu;
    }

    public void setNgaychieu(Date ngaychieu) {
        this.ngaychieu = ngaychieu;
    }

    public Time getThoigianBd() {
        return thoigianBd;
    }

    public void setThoigianBd(Time thoigianBd) {
        this.thoigianBd = thoigianBd;
    }

    public Time getThoigianKt() {
        return thoigianKt;
    }

    public void setThoigianKt(Time thoigianKt) {
        this.thoigianKt = thoigianKt;
    }

    public PhimD getPhim() {
        return phimD;
    }

    public void setPhim(PhimD phimD) {
        this.phimD = phimD;
    }

    public PhongchieuD getPhongchieu() {
        return phongchieuD;
    }

    public void setPhongchieu(PhongchieuD phongchieuD) {
        this.phongchieuD = phongchieuD;
    }

    public SuatchieuD(int idSuatchieu, int giaVe, Date ngaychieu, Time thoigianBd, Time thoigianKt, PhimD phimD, PhongchieuD phongchieuD) {
        IdSuatchieu = idSuatchieu;
        this.giaVe = giaVe;
        this.ngaychieu = ngaychieu;
        this.thoigianBd = thoigianBd;
        this.thoigianKt = thoigianKt;
        this.phimD = phimD;
        this.phongchieuD = phongchieuD;
    }
}
