package com.tka.virtual_assistant.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Meeting;
    private String ID_PhongHop;
    private String MaGoiNho;
    private String TenCuocHop;
    private java.util.Date ThoiGian;
    private String ID_Creator;
    private String FileTranscript;

    public int getID_Meeting() {
        return ID_Meeting;
    }

    public void setID_Meeting(int ID_Meeting) {
        this.ID_Meeting = ID_Meeting;
    }

    public String getID_PhongHop() {
        return ID_PhongHop;
    }

    public void setID_PhongHop(String ID_PhongHop) {
        this.ID_PhongHop = ID_PhongHop;
    }

    public String getMaGoiNho() {
        return MaGoiNho;
    }

    public void setMaGoiNho(String maGoiNho) {
        this.MaGoiNho = maGoiNho;
    }

    public String getTenCuocHop() {
        return TenCuocHop;
    }

    public void setTenCuocHop(String tenCuocHop) {
        this.TenCuocHop = tenCuocHop;
    }

    public java.util.Date getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(java.util.Date thoiGian) {
        this.ThoiGian = thoiGian;
    }

    public String getID_Creator() {
        return ID_Creator;
    }

    public void setID_Creator(String ID_Creator) {
        this.ID_Creator = ID_Creator;
    }

    public String getFileTranscript() {
        return FileTranscript;
    }

    public void setFileTranscript(String fileTranscript) {
        this.FileTranscript = fileTranscript;
    }
}
