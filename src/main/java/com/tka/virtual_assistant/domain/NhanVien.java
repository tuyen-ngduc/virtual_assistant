package com.tka.virtual_assistant.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_User;

    private String maNhanVien;
    private String TenNhanVien;
    private String NgaySinh;
    private String DienThoai;
    private String HocVi;
    private String CCCD;
    private String NgayCapCCCD;
    private String NoiCapCCCD;
    private String DiaChiCCCD;
    private String DiaChiHienNay;
    private String ChucVu;
    private String NoiCongTac;
    private String MaPhongBan;
    private String MaSoThue;
    private String SoTaiKhoan;
    private String NganHang;
    private String ChiNhanh;
    private String FileLyLich;
    private String MonGiangDayChinh;
    private String CacMonLienQuan;

    // Getters and Setters
    public int getID_User() {
        return ID_User;
    }

    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String mnv) {
        this.maNhanVien = mnv;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.TenNhanVien = tenNhanVien;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.NgaySinh = ngaySinh;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.DienThoai = dienThoai;
    }

    public String getHocVi() {
        return HocVi;
    }

    public void setHocVi(String hocVi) {
        this.HocVi = hocVi;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String cccd) {
        this.CCCD = cccd;
    }

    public String getNgayCapCCCD() {
        return NgayCapCCCD;
    }

    public void setNgayCapCCCD(String ngayCapCCCD) {
        this.NgayCapCCCD = ngayCapCCCD;
    }

    public String getNoiCapCCCD() {
        return NoiCapCCCD;
    }

    public void setNoiCapCCCD(String noiCapCCCD) {
        this.NoiCapCCCD = noiCapCCCD;
    }

    public String getDiaChiCCCD() {
        return DiaChiCCCD;
    }

    public void setDiaChiCCCD(String diaChiCCCD) {
        this.DiaChiCCCD = diaChiCCCD;
    }

    public String getDiaChiHienNay() {
        return DiaChiHienNay;
    }

    public void setDiaChiHienNay(String diaChiHienNay) {
        this.DiaChiHienNay = diaChiHienNay;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String chucVu) {
        this.ChucVu = chucVu;
    }

    public String getNoiCongTac() {
        return NoiCongTac;
    }

    public void setNoiCongTac(String noiCongTac) {
        this.NoiCongTac = noiCongTac;
    }

    public String getMaPhongBan() {
        return MaPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.MaPhongBan = maPhongBan;
    }

    public String getMaSoThue() {
        return MaSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.MaSoThue = maSoThue;
    }

    public String getSoTaiKhoan() {
        return SoTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.SoTaiKhoan = soTaiKhoan;
    }

    public String getNganHang() {
        return NganHang;
    }

    public void setNganHang(String nganHang) {
        this.NganHang = nganHang;
    }

    public String getChiNhanh() {
        return ChiNhanh;
    }

    public void setChiNhanh(String chiNhanh) {
        this.ChiNhanh = chiNhanh;
    }

    public String getFileLyLich() {
        return FileLyLich;
    }

    public void setFileLyLich(String fileLyLich) {
        this.FileLyLich = fileLyLich;
    }

    public String getMonGiangDayChinh() {
        return MonGiangDayChinh;
    }

    public void setMonGiangDayChinh(String monGiangDayChinh) {
        this.MonGiangDayChinh = monGiangDayChinh;
    }

    public String getCacMonLienQuan() {
        return CacMonLienQuan;
    }

    public void setCacMonLienQuan(String cacMonLienQuan) {
        this.CacMonLienQuan = cacMonLienQuan;
    }
}
