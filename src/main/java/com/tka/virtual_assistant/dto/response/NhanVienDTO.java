package com.tka.virtual_assistant.dto.response;

public class NhanVienDTO {
    private String maNhanVien;
    private String tenNhanVien;


    // Constructor
    public NhanVienDTO(String maNhanVien, String tenNhanVien, String maPhongBan) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
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


}
