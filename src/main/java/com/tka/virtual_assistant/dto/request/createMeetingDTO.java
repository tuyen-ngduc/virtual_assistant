package com.tka.virtual_assistant.dto.request;


import java.util.Date;

public class createMeetingDTO {
    private String tenCuocHop;


    private Date thoiGianBatDau;
    private String tenPhongBan;
    private String tenPhongHop;
    private String maChuTich;
    private String maThuKy;
    private String maGoiNho;

    public String getTenCuocHop() {
        return tenCuocHop;
    }

    public void setTenCuocHop(String tenCuocHop) {
        this.tenCuocHop = tenCuocHop;
    }

    public String getMaGoiNho() {
        return maGoiNho;
    }

    public void setMaGoiNho(String maGoiNho) {
        this.maGoiNho = maGoiNho;
    }

    public Date getThoiGian() {
        return thoiGianBatDau;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGianBatDau = thoiGian;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public String getTenPhongHop() {
        return tenPhongHop;
    }

    public void setTenPhongHop(String tenPhongHop) {
        this.tenPhongHop = tenPhongHop;
    }

    public String getMaChuTich() {
        return maChuTich;
    }

    public void setMaChuTich(String maChuTich) {
        this.maChuTich = maChuTich;
    }

    public String getMaThuKy() {
        return maThuKy;
    }

    public void setMaThuKy(String maThuKy) {
        this.maThuKy = maThuKy;
    }


}

