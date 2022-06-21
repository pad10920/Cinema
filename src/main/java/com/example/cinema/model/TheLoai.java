package com.example.cinema.model;

public class TheLoai {
    private int idTheloai;
    private String tenLoai;

    public TheLoai() {
    }

    public TheLoai(int idTheloai, String tenLoai) {
        this.idTheloai = idTheloai;
        this.tenLoai = tenLoai;
    }

    public int getIdTheloai() {
        return idTheloai;
    }

    public void setIdTheloai(int idTheloai) {
        this.idTheloai = idTheloai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    @Override
    public String toString() {
        return "TheLoai{" +
                "idTheloai=" + idTheloai +
                ", tenLoai='" + tenLoai + '\'' +
                '}';
    }
}
