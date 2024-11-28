package com.tka.virtual_assistant.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "phonghop")
public class PhongHop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID_PhongHop;
    private String tenPhongHop;
    private int SucChua;
    private String GhiChu;

    @OneToMany(mappedBy = "phongHop")
    private List<Meeting> meeting;

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
