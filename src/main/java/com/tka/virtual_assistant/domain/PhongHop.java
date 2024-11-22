package com.tka.virtual_assistant.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "phonghop")
public class PhongHop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID_PhongHop;
    private String tenPhongHop;
    private int SucChua;
    private String GhiChu;

    @OneToOne(mappedBy = "phongHop")
    private Meeting meeting;

    public long getID_PhongHop() {
        return ID_PhongHop;
    }

    public void setID_PhongHop(long ID_PhongHop) {
        this.ID_PhongHop = ID_PhongHop;
    }

    public String getTenPhongHop() {
        return tenPhongHop;
    }

    public void setTenPhongHop(String tenPhongHop) {
        this.tenPhongHop = tenPhongHop;
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
