package com.tka.virtual_assistant.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class NguoiThamGiaId implements Serializable {

    @Column(name = "id_nhanvien")
    private Long nhanVienId;

    @Column(name = "id_meeting")
    private Long meetingId;

    @Column(name = "id_chucdanh")
    private Long chucDanhId;

    // Constructors, getters, setters

    public NguoiThamGiaId() {}

    public NguoiThamGiaId(long nhanVienId, long meetingId, long chucDanhId) {
        this.nhanVienId = nhanVienId;
        this.meetingId = meetingId;
        this.chucDanhId = chucDanhId;
    }

    // Getters and Setters

    public long getNhanVienId() {
        return nhanVienId;
    }

    public void setNhanVienId(long nhanVienId) {
        this.nhanVienId = nhanVienId;
    }

    public long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(long meetingId) {
        this.meetingId = meetingId;
    }

    public long getChucDanhId() {
        return chucDanhId;
    }

    public void setChucDanhId(long chucDanhId) {
        this.chucDanhId = chucDanhId;
    }

    // Equals and hashCode methods to compare objects correctly

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NguoiThamGiaId that = (NguoiThamGiaId) o;
        return nhanVienId == that.nhanVienId &&
                meetingId == that.meetingId &&
                chucDanhId == that.chucDanhId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nhanVienId, meetingId, chucDanhId);
    }
}
