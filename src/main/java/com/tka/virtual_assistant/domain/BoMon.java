package com.tka.virtual_assistant.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "bomon")
public class BoMon {

    @Id
    private String maBoMon;

    private String tenBoMon;
    private String truongBoMon;

    @ManyToOne
    @JoinColumn(name = "MaPhongBan", nullable = false)
    private PhongBan phongBan;

    // Getters and Setters
    public String getMaBoMon() {
        return maBoMon;
    }

    public void setMaBoMon(String maBoMon) {
        this.maBoMon = maBoMon;
    }

    public String getTenBoMon() {
        return tenBoMon;
    }

    public void setTenBoMon(String tenBoMon) {
        this.tenBoMon = tenBoMon;
    }

    public String getTruongBoMon() {
        return truongBoMon;
    }

    public void setTruongBoMon(String truongBoMon) {
        this.truongBoMon = truongBoMon;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }
}

