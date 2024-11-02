package com.tka.virtual_assistant.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name = "phongban")
public class PhongBan {

    @Id
    private String maPhongBan;
    
    private String tenPhongBan;
    private String ghiChu;

    @OneToMany(mappedBy = "phongBan")
    private List<BoMon> boMons;

    // Getters and Setters
    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public List<BoMon> getBoMons() {
        return boMons;
    }

    public void setBoMons(List<BoMon> boMons) {
        this.boMons = boMons;
    }
}

