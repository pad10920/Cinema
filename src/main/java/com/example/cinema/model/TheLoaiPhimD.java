package com.example.cinema.model;

public class TheLoaiPhimD {
    private int idTheloaiphim;
    private int idPhim;
    private int idTheloai;

    public TheLoaiPhimD() {
    }

    public TheLoaiPhimD(int idTheloaiphim, int idPhim, int idTheloai) {
        this.idTheloaiphim = idTheloaiphim;
        this.idPhim = idPhim;
        this.idTheloai = idTheloai;
    }

    public int getIdTheloaiphim() {
        return idTheloaiphim;
    }

    public void setIdTheloaiphim(int idTheloaiphim) {
        this.idTheloaiphim = idTheloaiphim;
    }

    public int getIdPhim() {
        return idPhim;
    }

    public void setIdPhim(int idPhim) {
        this.idPhim = idPhim;
    }

    public int getIdTheloai() {
        return idTheloai;
    }

    public void setIdTheloai(int idTheloai) {
        this.idTheloai = idTheloai;
    }

    @Override
    public String toString() {
        return "TheLoaiPhimD{" +
                "idTheloaiphim=" + idTheloaiphim +
                ", idPhim=" + idPhim +
                ", idTheloai=" + idTheloai +
                '}';
    }
}
