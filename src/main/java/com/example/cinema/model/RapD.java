package com.example.cinema.model;

import java.util.List;

public class RapD {
    private int idRap;
    private String tenRap;
    private String diaChi;
    private String thongTin;
    private List<PhongchieuD> phongChieu;

    public RapD(int idRap, String tenRap, String diaChi, String thongTin, List<PhongchieuD> phongChieu) {
        this.idRap = idRap;
        this.tenRap = tenRap;
        this.diaChi = diaChi;
        this.thongTin = thongTin;
        this.phongChieu = phongChieu;
    }

    public RapD() {
    }

    @Override
    public String toString() {
        return "RapD{" +
                "idRap=" + idRap +
                ", tenRap='" + tenRap + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", thongTin='" + thongTin + '\'' +
                ", phongChieu=" + phongChieu +
                '}';
    }

    public int getIdRap() {
        return idRap;
    }

    public void setIdRap(int idRap) {
        this.idRap = idRap;
    }

    public String getTenRap() {
        return tenRap;
    }

    public void setTenRap(String tenRap) {
        this.tenRap = tenRap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    public List<PhongchieuD> getPhongChieu() {
        return phongChieu;
    }

    public void setPhongChieu(List<PhongchieuD> phongChieu) {
        this.phongChieu = phongChieu;
    }
}
