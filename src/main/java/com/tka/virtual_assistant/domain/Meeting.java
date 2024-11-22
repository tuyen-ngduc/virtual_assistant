package com.tka.virtual_assistant.domain;

import java.util.List;

import com.tka.virtual_assistant.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.Date;

@Entity(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenCuocHop;
    private Date thoiGianBatDau;
    private Date thoiGianKetThuc;
    private Status status;
    private String maGoiNho;

    @ManyToOne
    @JoinColumn(name = "chutich_id", nullable = false)
    private NhanVien chuTich;

    @ManyToOne
    @JoinColumn(name = "thuky_id", nullable = false)
    private NhanVien thuKy;

    private String fileTranscript;


    @OneToOne
    @JoinColumn(name = "id_Creater")
    private NhanVien nhanVien;

    @OneToMany(mappedBy = "meeting")
    private List<NguoiThamGia> nguoiThamGiaList;

    @OneToOne
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

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
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

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
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
