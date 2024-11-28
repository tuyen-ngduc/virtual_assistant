package com.tka.virtual_assistant.dto.request;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class createMeetingDTO {
    private String tenCuocHop;
    private LocalDateTime thoiGianBatDau;
    private String tenPhongBan;
    private String tenPhongHop;
    private String maChuTich;
    private String maThuKy;

    private String maGoiNho;
    private List<String> maNhanVienThamGia;


    public List<String> getMaNhanVienThamGia() {
        return maNhanVienThamGia;
    }

    public void setMaNhanVienThamGia(List<String> maNhanVienThamGia) {
        this.maNhanVienThamGia = maNhanVienThamGia;
    }

    public LocalDateTime getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalDateTime thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

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

