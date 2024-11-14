package com.tka.virtual_assistant.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
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

    private String TenCuocHop;
    private Date ThoiGian;
    private String Status;
    private String MaGoiNho;

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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public PhongHop getPhongHop() {
        return phongHop;
    }

    public void setPhongHop(PhongHop phongHop) {
        this.phongHop = phongHop;
    }

    public String getMaGoiNho() {
        return MaGoiNho;
    }

    public void setMaGoiNho(String maGoiNho) {
        this.MaGoiNho = maGoiNho;
    }

    public String getTenCuocHop() {
        return TenCuocHop;
    }

    public void setTenCuocHop(String tenCuocHop) {
        this.TenCuocHop = tenCuocHop;
    }

    public java.util.Date getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(java.util.Date thoiGian) {
        this.ThoiGian = thoiGian;
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

}
