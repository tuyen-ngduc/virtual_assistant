package com.tka.virtual_assistant.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String maNhanVien;
    private String tenNhanVien;
    private String ngaySinh;
    private String dienThoai;
    private String hocVi;
    private String CCCD;
    private String ngayCapCCCD;
    private String noiCapCCCD;
    private String diaChiCCCD;
    private String diaChiHienNay;
    private String chucVu;
    private String noiCongTac;
    private String maSoThue;
    private String soTaiKhoan;
    private String nganHang;
    private String chiNhanh;
    private String fileLyLich;
    private String monGiangDayChinh;
    private String cacMonLienQuan;

    @JsonIgnore
    @OneToOne(mappedBy = "nhanVien")
    private Account account;

    @OneToOne(mappedBy = "nhanVien")
    private NguoiThamGia nguoiThamGia;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_phongban")
    private PhongBan phongBan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String cCCD) {
        CCCD = cCCD;
    }

    public String getNgayCapCCCD() {
        return ngayCapCCCD;
    }

    public void setNgayCapCCCD(String ngayCapCCCD) {
        this.ngayCapCCCD = ngayCapCCCD;
    }

    public String getNoiCapCCCD() {
        return noiCapCCCD;
    }

    public void setNoiCapCCCD(String noiCapCCCD) {
        this.noiCapCCCD = noiCapCCCD;
    }

    public String getDiaChiCCCD() {
        return diaChiCCCD;
    }

    public void setDiaChiCCCD(String diaChiCCCD) {
        this.diaChiCCCD = diaChiCCCD;
    }

    public String getDiaChiHienNay() {
        return diaChiHienNay;
    }

    public void setDiaChiHienNay(String diaChiHienNay) {
        this.diaChiHienNay = diaChiHienNay;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getNoiCongTac() {
        return noiCongTac;
    }

    public void setNoiCongTac(String noiCongTac) {
        this.noiCongTac = noiCongTac;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getNganHang() {
        return nganHang;
    }

    public void setNganHang(String nganHang) {
        this.nganHang = nganHang;
    }

    public String getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(String chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    public String getFileLyLich() {
        return fileLyLich;
    }

    public void setFileLyLich(String fileLyLich) {
        this.fileLyLich = fileLyLich;
    }

    public String getMonGiangDayChinh() {
        return monGiangDayChinh;
    }

    public void setMonGiangDayChinh(String monGiangDayChinh) {
        this.monGiangDayChinh = monGiangDayChinh;
    }

    public String getCacMonLienQuan() {
        return cacMonLienQuan;
    }

    public void setCacMonLienQuan(String cacMonLienQuan) {
        this.cacMonLienQuan = cacMonLienQuan;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public NguoiThamGia getNguoiThamGia() {
        return nguoiThamGia;
    }

    public void setNguoiThamGia(NguoiThamGia nguoiThamGia) {
        this.nguoiThamGia = nguoiThamGia;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

}
