package com.tka.virtual_assistant.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "phonghop")
public class PhongHop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_PhongHop;
    private String TenPhongHop;
    private int SucChua;
    private String GhiChu;

    public int getID_PhongHop() {
        return ID_PhongHop;
    }

    public void setID_PhongHop(int ID_PhongHop) {
        this.ID_PhongHop = ID_PhongHop;
    }

    public String getTenPhongHop() {
        return TenPhongHop;
    }

    public void setTenPhongHop(String tenPhongHop) {
        this.TenPhongHop = tenPhongHop;
    }

    public int getSucChua() {
        return SucChua;
    }

    public void setSucChua(int sucChua) {
        this.SucChua = sucChua;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.GhiChu = ghiChu;
    }
}
