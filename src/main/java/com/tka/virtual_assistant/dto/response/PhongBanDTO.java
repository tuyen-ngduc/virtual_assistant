package com.tka.virtual_assistant.dto.response;

public class PhongBanDTO {
    private String tenPhongBan;

    // Constructor
    public PhongBanDTO(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    // Getter and Setter
    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }
}

