package com.example.cinema.model;

import java.util.List;

/**
 *
 * @author cuong
 */
public class PhimD {
    private int idPhim;
    private String tenPhim;
    private int thoiLuong;
    private String moTa;
    private String quocGia;
    private String anhPhim;
    private int trangThai;
    private List<TheLoaiD> theLoaiDS;
    public PhimD() {
    }

    public PhimD(int idPhim, String tenPhim, int thoiLuong, String moTa, String quocGia, String anhPhim, int trangThai) {
        this.idPhim = idPhim;
        this.tenPhim = tenPhim;
        this.thoiLuong = thoiLuong;
        this.moTa = moTa;
        this.quocGia = quocGia;
        this.anhPhim = anhPhim;
        this.trangThai = trangThai;
    }
    public PhimD(String tenPhim, int thoiLuong, String moTa, String quocGia, String anhPhim, int trangThai) {
        this.tenPhim = tenPhim;
        this.thoiLuong = thoiLuong;
        this.moTa = moTa;
        this.quocGia = quocGia;
        this.anhPhim = anhPhim;
        this.trangThai = trangThai;
    }

    public PhimD(String tenPhim, int thoiLuong, String moTa, String quocGia, String anhPhim, int trangThai, List<String> loaiPhim) {
       
        this.tenPhim = tenPhim;
        this.thoiLuong = thoiLuong;
        this.moTa = moTa;
        this.quocGia = quocGia;
        this.anhPhim = anhPhim;
        this.trangThai = trangThai;
    }

    public int getId() {
        return idPhim;
    }

    public void setId(int idPhim) {
        this.idPhim = idPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getAnhPhim() {
        return anhPhim;
    }

    public void setAnhPhim(String anhPhim) {
        this.anhPhim = anhPhim;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getIdPhim() {
        return idPhim;
    }

    public void setIdPhim(int idPhim) {
        this.idPhim = idPhim;
    }

    public List<TheLoaiD> getTheLoais() {
        return theLoaiDS;
    }

    public void setTheLoais(List<TheLoaiD> theLoaiDS) {
        this.theLoaiDS = theLoaiDS;
    }

    @Override
    public String toString() {
        return "PhimD{" +
                "idPhim=" + idPhim +
                ", tenPhim='" + tenPhim + '\'' +
                ", thoiLuong=" + thoiLuong +
                ", moTa='" + moTa + '\'' +
                ", quocGia='" + quocGia + '\'' +
                ", anhPhim='" + anhPhim + '\'' +
                ", trangThai=" + trangThai +
                ", theLoaiDS=" + theLoaiDS +
                '}';
    }
}
