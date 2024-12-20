package com.tka.virtual_assistant.dto.response;

import com.tka.virtual_assistant.domain.Meeting;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class MeetingDTO {
    private Long maCuocHop;
    private String tenCuocHop;
    private LocalDateTime thoiGianBatDau;
    private String phongBan;
    private String phongHop;
    private String status;
    private String maGoiNho;
//    private String fileTranscript;
//    private String nguoiTao;

    public String getTenCuocHop() {
        return tenCuocHop;
    }

    public void setTenCuocHop(String tenCuocHop) {
        this.tenCuocHop = tenCuocHop;
    }

    public LocalDateTime getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public Long getMaCuocHop() {
        return maCuocHop;
    }

    public void setMaCuocHop(Long maCuocHop) {
        this.maCuocHop = maCuocHop;
    }

    public void setThoiGianBatDau(LocalDateTime thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getPhongHop() {
        return phongHop;
    }

    public void setPhongHop(String phongHop) {
        this.phongHop = phongHop;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMaGoiNho() {
        return maGoiNho;
    }

    public void setMaGoiNho(String maGoiNho) {
        this.maGoiNho = maGoiNho;
    }





}
