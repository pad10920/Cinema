package com.example.cinema.model;

import java.util.List;

/**
 *
 * @author cuong
 */
public class Phim {
    private int idPhim;
    private String tenPhim;
    private int thoiLuong;
    private String moTa;
    private String quocGia;
    private String anhPhim;
    private int trangThai;
    private List<String> loaiPhim;
    public Phim() {
    }

    public Phim(int idPhim, String tenPhim, int thoiLuong, String moTa, String quocGia, String anhPhim, int trangThai) {
        this.idPhim = idPhim;
        this.tenPhim = tenPhim;
        this.thoiLuong = thoiLuong;
        this.moTa = moTa;
        this.quocGia = quocGia;
        this.anhPhim = anhPhim;
        this.trangThai = trangThai;
    }
    public Phim(String tenPhim, int thoiLuong, String moTa, String quocGia, String anhPhim, int trangThai) {
        this.tenPhim = tenPhim;
        this.thoiLuong = thoiLuong;
        this.moTa = moTa;
        this.quocGia = quocGia;
        this.anhPhim = anhPhim;
        this.trangThai = trangThai;
    }

    public Phim(String tenPhim, int thoiLuong, String moTa, String quocGia, String anhPhim, int trangThai, List<String> loaiPhim) {
       
        this.tenPhim = tenPhim;
        this.thoiLuong = thoiLuong;
        this.moTa = moTa;
        this.quocGia = quocGia;
        this.anhPhim = anhPhim;
        this.trangThai = trangThai;
        this.loaiPhim = loaiPhim;
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

    public List<String> getLoaiPhim() {
        return loaiPhim;
    }

    public void setLoaiPhim(List<String> loaiPhim) {
        this.loaiPhim = loaiPhim;
    }
     
}
