package com.example.cinema.model;

import java.sql.Date;
import java.sql.Time;

public class Suatchieu {
    private int IdSuatchieu;
    private int giaVe;
    private Date ngaychieu;
    private Time thoigianBd;
    private Time thoigianKt;
    private Phim phim;
    private Phongchieu phongchieu;

    public Suatchieu() {
    }

    @Override
    public String toString() {
        return "Suatchieu{" +
                "IdSuatchieu=" + IdSuatchieu +
                ", giaVe=" + giaVe +
                ", ngaychieu=" + ngaychieu +
                ", thoigianBd=" + thoigianBd +
                ", thoigianKt=" + thoigianKt +
                ", phim=" + phim +
                ", phongchieu=" + phongchieu +
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

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    public Phongchieu getPhongchieu() {
        return phongchieu;
    }

    public void setPhongchieu(Phongchieu phongchieu) {
        this.phongchieu = phongchieu;
    }

    public Suatchieu(int idSuatchieu, int giaVe, Date ngaychieu, Time thoigianBd, Time thoigianKt, Phim phim, Phongchieu phongchieu) {
        IdSuatchieu = idSuatchieu;
        this.giaVe = giaVe;
        this.ngaychieu = ngaychieu;
        this.thoigianBd = thoigianBd;
        this.thoigianKt = thoigianKt;
        this.phim = phim;
        this.phongchieu = phongchieu;
    }
}
