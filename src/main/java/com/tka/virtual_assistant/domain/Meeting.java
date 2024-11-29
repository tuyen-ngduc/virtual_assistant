package com.tka.virtual_assistant.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tka.virtual_assistant.enums.Status;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenCuocHop;
    private LocalDateTime thoiGianBatDau;
    private LocalDateTime thoiGianKetThuc;
    private Status status;
    private String maGoiNho;

    @ManyToOne
    @JoinColumn(name = "chutich_id", nullable = false)
    private NhanVien chuTich;

    @ManyToOne
    @JoinColumn(name = "thuky_id", nullable = false)
    private NhanVien thuKy;

    private String fileTranscript;

    @OneToMany(mappedBy = "meeting")
    private List<NguoiThamGia> nguoiThamGiaList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_phonghop")
    private PhongHop phongHop;

    @ManyToOne
    @JoinColumn(name = "id_phongban")
    private PhongBan phongBan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<NguoiThamGia> getNguoiThamGiaList() {
        return nguoiThamGiaList;
    }

    public void setNguoiThamGiaList(List<NguoiThamGia> nguoiThamGiaList) {
        this.nguoiThamGiaList = nguoiThamGiaList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PhongHop getPhongHop() {
        return phongHop;
    }

    public void setPhongHop(PhongHop phongHop) {
        this.phongHop = phongHop;
    }

    public String getTenCuocHop() {
        return tenCuocHop;
    }

    public void setTenCuocHop(String tenCuocHop) {
        this.tenCuocHop = tenCuocHop;
    }

    public LocalDateTime getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalDateTime thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public LocalDateTime getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(LocalDateTime thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getMaGoiNho() {
        return maGoiNho;
    }

    public void setMaGoiNho(String maGoiNho) {
        this.maGoiNho = maGoiNho;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }


    public String getFileTranscript() {
        return fileTranscript;
    }

    public void setFileTranscript(String fileTranscript) {
        this.fileTranscript = fileTranscript;
    }

    public NhanVien getChuTich() {
        return chuTich;
    }

    public void setChuTich(NhanVien chuTich) {
        this.chuTich = chuTich;
    }

    public NhanVien getThuKy() {
        return thuKy;
    }

    public void setThuKy(NhanVien thuKy) {
        this.thuKy = thuKy;
    }


}
