package com.tka.virtual_assistant.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "nguoithamgia")
public class NguoiThamGia {
    @EmbeddedId
    private NguoiThamGiaId id; // Khóa chính composite

    @ManyToOne
    @JoinColumn(name = "id_chucdanh", insertable = false, updatable = false)
    private ChucDanh chucDanh;

    @ManyToOne
    @JoinColumn(name = "id_nhanvien", insertable = false, updatable = false)
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "id_meeting", insertable = false, updatable = false)
    private Meeting meeting;

    // Getters and Setters

    public NguoiThamGiaId getId() {
        return id;
    }

    public void setId(NguoiThamGiaId id) {
        this.id = id;
    }

    public ChucDanh getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(ChucDanh chucDanh) {
        this.chucDanh = chucDanh;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }
}
