package com.tka.virtual_assistant.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "nguoithamgia")
@IdClass(NguoiThamGiaId.class)
public class NguoiThamGia {
    @Id
    private int ID_User;

    @Id
    private int ID_Meeting;

    private String ChucDanh;

    // Getters and Setters
    public int getID_User() {
        return ID_User;
    }

    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }

    public int getID_Meeting() {
        return ID_Meeting;
    }

    public void setID_Meeting(int ID_Meeting) {
        this.ID_Meeting = ID_Meeting;
    }

    public String getChucDanh() {
        return ChucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.ChucDanh = chucDanh;
    }
}
