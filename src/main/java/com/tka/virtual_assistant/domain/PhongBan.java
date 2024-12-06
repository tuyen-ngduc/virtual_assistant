package com.tka.virtual_assistant.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToMany(mappedBy = "phongBan")
    private List<BoMon> boMonList;
    @JsonIgnore
    @OneToMany(mappedBy = "phongBan")
    private List<NhanVien> nhanVienList;
    @JsonIgnore
    @OneToMany(mappedBy = "phongBan")
    private List<Meeting> meetingList;

    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    public void setMeetingList(List<Meeting> meetingList) {
        this.meetingList = meetingList;
    }

    public List<BoMon> getBoMonList() {
        return boMonList;
    }

    public void setBoMonList(List<BoMon> boMonList) {
        this.boMonList = boMonList;
    }

    public List<NhanVien> getNhanVienList() {
        return nhanVienList;
    }

    public void setNhanVienList(List<NhanVien> nhanVienList) {
        this.nhanVienList = nhanVienList;
    }

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

}