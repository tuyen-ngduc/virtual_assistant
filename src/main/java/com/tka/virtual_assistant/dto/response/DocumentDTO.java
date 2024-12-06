package com.tka.virtual_assistant.dto.response;

public class DocumentDTO {

    private String tenCuocHop;  // Tên cuộc họp
    private String maGoiNho;    // Mã gợi nhớ
    private String phongBan;    // Tên phòng ban
    private String fileTranscript;  // File transcript

    public DocumentDTO() {}


    // Constructor
    public DocumentDTO(String tenCuocHop, String maGoiNho, String phongBan, String fileTranscript) {
        this.tenCuocHop = tenCuocHop;
        this.maGoiNho = maGoiNho;
        this.phongBan = phongBan;
        this.fileTranscript = fileTranscript;
    }

    // Getters and Setters
    public String getTenCuocHop() {
        return tenCuocHop;
    }

    public void setTenCuocHop(String tenCuocHop) {
        this.tenCuocHop = tenCuocHop;
    }

    public String getMaGoiNho() {
        return maGoiNho;
    }

    public void setMaGoiNho(String maGoiNho) {
        this.maGoiNho = maGoiNho;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getFileTranscript() {
        return fileTranscript;
    }

    public void setFileTranscript(String fileTranscript) {
        this.fileTranscript = fileTranscript;
    }
}


