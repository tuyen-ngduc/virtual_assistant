package com.tka.virtual_assistant.dto.response;

import com.tka.virtual_assistant.domain.Meeting;

import java.time.Duration;

public class MeetingDTO {
    private String tenCuocHop;
    private String maGoiNho;
    private String thoiGianBatDau;
    private String thoiGianKetThuc;
    private String phongBan;
    private String phongHop;
    private String nguoiTao;
    private String status;
    private String fileTranscript;
    private Long durationMinutes; // Tính thời gian cuộc họp trực tiếp

    public MeetingDTO(Meeting meeting) {
        this.tenCuocHop = meeting.getTenCuocHop();
        this.maGoiNho = meeting.getMaGoiNho();
        this.thoiGianBatDau = meeting.getThoiGianBatDau() != null ? meeting.getThoiGianBatDau().toString() : null;
        this.thoiGianKetThuc = meeting.getThoiGianKetThuc() != null ? meeting.getThoiGianKetThuc().toString() : null;
        this.phongBan = meeting.getPhongBan() != null ? meeting.getPhongBan().getTenPhongBan() : null;
        this.phongHop = meeting.getPhongHop() != null ? meeting.getPhongHop().getTenPhongHop() : null;
        this.nguoiTao = meeting.getThuKy() != null ? meeting.getThuKy().getTenNhanVien() : null;
        this.status = meeting.getStatus() != null ? meeting.getStatus().toString() : null;
        this.fileTranscript = meeting.getFileTranscript();

        // Tính thời gian diễn ra cuộc họp (nếu thời gian bắt đầu và kết thúc có giá trị)
        if (meeting.getThoiGianBatDau() != null && meeting.getThoiGianKetThuc() != null) {
            long duration = Duration.between(
                    meeting.getThoiGianBatDau().toInstant(),
                    meeting.getThoiGianKetThuc().toInstant()
            ).toMinutes();
            this.durationMinutes = duration > 0 ? duration : 0; // Đảm bảo không có giá trị âm
        } else {
            this.durationMinutes = null;
        }
    }

    // Getter và Setter nếu cần
}
