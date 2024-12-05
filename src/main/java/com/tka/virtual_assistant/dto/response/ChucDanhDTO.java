package com.tka.virtual_assistant.dto.response;

public class ChucDanhDTO {
    private String tenChucDanh;

    // Constructor
    public ChucDanhDTO(String tenChucDanh) {
        this.tenChucDanh = tenChucDanh;
    }

    // Getter and Setter
    public String getTenChucDanh() {
        return tenChucDanh;
    }

    public void setTenChucDanh(String tenChucDanh) {
        this.tenChucDanh = tenChucDanh;
    }
}
