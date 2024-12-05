package com.tka.virtual_assistant.dto.request;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CreateMeetingDTO {
    private String tenCuocHop;
    private LocalDateTime thoiGianBatDau;
    private String tenPhongBan;
    private String tenPhongHop;

    private String maGoiNho;
    private List<NguoiThamGiaDTO> maNhanVienThamGia;


    public List<NguoiThamGiaDTO> getMaNhanVienThamGia() {
        return maNhanVienThamGia;
    }

    public void setMaNhanVienThamGia(List<NguoiThamGiaDTO> maNhanVienThamGia) {
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




}

