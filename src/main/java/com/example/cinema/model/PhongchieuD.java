package com.example.cinema.model;

public class PhongchieuD {
    private int idPhongchieu;
    private String tenPhong;
    private int soLuongGhe;
    private RapD rapD;

    public PhongchieuD() {
    }

    public PhongchieuD(int idPhongchieu, String tenPhong, int soLuongGhe, RapD rapD) {
        this.idPhongchieu = idPhongchieu;
        this.tenPhong = tenPhong;
        this.soLuongGhe = soLuongGhe;
        this.rapD = rapD;
    }

    public int getIdPhongchieu() {
        return idPhongchieu;
    }

    public void setIdPhongchieu(int idPhongchieu) {
        this.idPhongchieu = idPhongchieu;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(int soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
    }

    public RapD getRap() {
        return rapD;
    }

    public void setRap(RapD rapD) {
        this.rapD = rapD;
    }

    @Override
    public String toString() {
        return "PhongchieuD{" +
                "idPhongchieu=" + idPhongchieu +
                ", tenPhong='" + tenPhong + '\'' +
                ", soLuongGhe=" + soLuongGhe +
                ", rapD=" + rapD +
                '}';
    }
}
