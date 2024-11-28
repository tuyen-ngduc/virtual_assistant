package com.tka.virtual_assistant.dto.response;

public class NhanVienDTO {
    private String maNhanVien;
    private String tenNhanVien;
    private String maPhongBan;

    // Constructor
    public NhanVienDTO(String maNhanVien, String tenNhanVien, String maPhongBan) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.maPhongBan = maPhongBan;
    }

    // Getter & Setter
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

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }
}
