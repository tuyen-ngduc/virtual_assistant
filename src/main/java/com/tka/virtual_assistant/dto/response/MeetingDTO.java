package com.tka.virtual_assistant.dto.response;

import com.tka.virtual_assistant.domain.Meeting;

import java.time.Duration;
import java.util.Date;

public class MeetingDTO {
    private String tenCuocHop;
    private Date thoiGianBatDau;
    private String phongBan;
    private String phongHop;
    private String status;
    private String maGoiNho;
    private String fileTranscript;
    private String nguoiTao;

    public String getTenCuocHop() {
        return tenCuocHop;
    }

    public void setTenCuocHop(String tenCuocHop) {
        this.tenCuocHop = tenCuocHop;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGian) {
        this.thoiGianBatDau = thoiGian;
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

    public String getFileTranscript() {
        return fileTranscript;
    }

    public void setFileTranscript(String fileTranscript) {
        this.fileTranscript = fileTranscript;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

}
