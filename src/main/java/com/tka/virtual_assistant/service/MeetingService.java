package com.tka.virtual_assistant.service;

import com.tka.virtual_assistant.domain.*;
import com.tka.virtual_assistant.dto.request.createMeetingDTO;
import com.tka.virtual_assistant.dto.response.MeetingDTO;
import com.tka.virtual_assistant.enums.Status;
import com.tka.virtual_assistant.repository.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeetingService {
    private final MeetingRepository meetingRepository;
    private final PhongBanRepository phongBanRepository;
    private final PhongHopRepository phongHopRepository;
    private final NhanVienRepository nhanVienRepository;

    private final NguoiThamGiaRepository nguoiThamGiaRepository;

    public MeetingService(
            MeetingRepository meetingRepository,
            PhongBanRepository phongBanRepository,
            PhongHopRepository phongHopRepository,
            NhanVienRepository nhanVienRepository,
            NguoiThamGiaRepository nguoiThamGiaRepository) {
        this.meetingRepository = meetingRepository;
        this.phongBanRepository = phongBanRepository;
        this.phongHopRepository = phongHopRepository;
        this.nhanVienRepository = nhanVienRepository;
        this.nguoiThamGiaRepository = nguoiThamGiaRepository;
    }

    public List<MeetingDTO> getAllMeetings() {
        // Lấy danh sách tất cả cuộc họp
        List<Meeting> meetings = meetingRepository.findAll();

        // Chuyển đổi từ Meeting sang MeetingDTO
        return meetings.stream().map(meeting -> {
            MeetingDTO dto = new MeetingDTO();
            dto.setTenCuocHop(meeting.getTenCuocHop());
            dto.setThoiGianBatDau(meeting.getThoiGianBatDau());
            dto.setPhongBan(meeting.getPhongBan().getTenPhongBan());
            dto.setPhongHop(meeting.getPhongHop().getTenPhongHop());
            dto.setStatus(meeting.getStatus().getDescription());
            dto.setMaGoiNho(meeting.getMaGoiNho());
            dto.setFileTranscript(meeting.getFileTranscript());
            dto.setNguoiTao(meeting.getThuKy().getTenNhanVien());
            return dto;
        }).collect(Collectors.toList());
    }


        public String createMeeting(createMeetingDTO createMeetingDTO) {
            // Kiểm tra phòng ban
            PhongBan phongBan = phongBanRepository.findByTenPhongBan(createMeetingDTO.getTenPhongBan())
                    .orElseThrow(() -> new RuntimeException("Phòng ban không tồn tại: " + createMeetingDTO.getTenPhongBan()));

            // Kiểm tra phòng họp
            PhongHop phongHop = phongHopRepository.findByTenPhongHop(createMeetingDTO.getTenPhongHop())
                    .orElseThrow(() -> new RuntimeException("Phòng họp không tồn tại: " + createMeetingDTO.getTenPhongHop()));

            // Kiểm tra Chủ tịch
            NhanVien chuTich = nhanVienRepository.findByMaNhanVien(createMeetingDTO.getMaChuTich())
                    .orElseThrow(() -> new RuntimeException("Mã Chủ tịch không tồn tại: " + createMeetingDTO.getMaChuTich()));

            // Kiểm tra Thư ký
            NhanVien thuKy = nhanVienRepository.findByMaNhanVien(createMeetingDTO.getMaThuKy())
                    .orElseThrow(() -> new RuntimeException("Mã Thư ký không tồn tại: " + createMeetingDTO.getMaThuKy()));

            // Thời gian bắt đầu và kết thúc của cuộc họp
            LocalDateTime thoiGianBatDau = createMeetingDTO.getThoiGianBatDau();
            LocalDateTime thoiGianKetThuc = thoiGianBatDau.plusHours(2); // 2 tiếng sau khi bắt đầu
            System.out.println("Thời gian : " + thoiGianKetThuc);
            System.out.println("Thòi gian: " + thoiGianBatDau);

            // Kiểm tra thời gian phòng họp
            List<Meeting> existingMeetingsInRoom = meetingRepository.findMeetingsByPhongHopAndTime(
                    phongHop.getID_PhongHop(), thoiGianBatDau, thoiGianKetThuc
            );
            if (!existingMeetingsInRoom.isEmpty()) {
                return "Phòng họp đã được sử dụng trong khoảng thời gian này.";
            }

            // Kiểm tra thời gian của các nhân viên tham gia
            List<String> maNhanVienThamGia = createMeetingDTO.getMaNhanVienThamGia();
            for (String maNhanVien : maNhanVienThamGia) {
                NhanVien nhanVien = nhanVienRepository.findByMaNhanVien(maNhanVien)
                        .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên với mã: " + maNhanVien));

                // Kiểm tra xem nhân viên đã tham gia cuộc họp khác không
                List<NguoiThamGia> existingParticipations = nguoiThamGiaRepository.findByNhanVienAndTime(
                        nhanVien.getId(), thoiGianBatDau, thoiGianKetThuc
                );
                if (!existingParticipations.isEmpty()) {
                    return "Nhân viên " + maNhanVien + " đã tham gia cuộc họp khác trong khoảng thời gian này.";
                }
            }

            // Tạo mới cuộc họp
            Meeting meeting = new Meeting();
            meeting.setTenCuocHop(createMeetingDTO.getTenCuocHop());
            meeting.setMaGoiNho(createMeetingDTO.getMaGoiNho());
            meeting.setThoiGianBatDau(createMeetingDTO.getThoiGianBatDau());
            meeting.setThoiGianKetThuc(thoiGianKetThuc);
            meeting.setPhongBan(phongBan);
            meeting.setPhongHop(phongHop);
            meeting.setChuTich(chuTich);
            meeting.setThuKy(thuKy);
            meeting.setStatus(Status.UPCOMING);

            try {
                String transcriptFilePath = saveMeetingTranscript(meeting);
                meeting.setFileTranscript(transcriptFilePath);
            } catch (IOException e) {
                return "Lỗi khi tạo file transcript: " + e.getMessage();
            }


            // Lưu cuộc họp vào cơ sở dữ liệu
            meetingRepository.save(meeting);

            // Thêm nhân viên tham gia vào cuộc họp
            for (String maNhanVien : maNhanVienThamGia) {
                NhanVien nhanVien = nhanVienRepository.findByMaNhanVien(maNhanVien)
                        .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên với mã: " + maNhanVien));

                NguoiThamGia nguoiThamGia = new NguoiThamGia();
                nguoiThamGia.setNhanVien(nhanVien);
                nguoiThamGia.setMeeting(meeting);
                nguoiThamGia.setChucDanh("Thành viên");

                nguoiThamGiaRepository.save(nguoiThamGia);
            }
            // Thêm Chủ tịch vào danh sách người tham gia
            NguoiThamGia nguoiThamGiaChuTich = new NguoiThamGia();
            nguoiThamGiaChuTich.setNhanVien(chuTich);
            nguoiThamGiaChuTich.setMeeting(meeting);
            nguoiThamGiaChuTich.setChucDanh("Chủ tịch");
            nguoiThamGiaRepository.save(nguoiThamGiaChuTich);

            // Thêm Thư ký vào danh sách người tham gia
            NguoiThamGia nguoiThamGiaThuKy = new NguoiThamGia();
            nguoiThamGiaThuKy.setNhanVien(thuKy);
            nguoiThamGiaThuKy.setMeeting(meeting);
            nguoiThamGiaThuKy.setChucDanh("Thư ký");
            nguoiThamGiaRepository.save(nguoiThamGiaThuKy);



            return "Cuộc họp được tạo thành công.";
        }

    private String saveMeetingTranscript(Meeting meeting) throws IOException {
        String meetingFolderName = meeting.getMaGoiNho();
        Path meetingFolderPath = Paths.get("meeting_transcripts", meetingFolderName);
        File meetingFolder = new File(meetingFolderPath.toString());
        if (!meetingFolder.exists()) {
            meetingFolder.mkdirs();
        }

        String transcriptFileName = "transcript.txt";
        Path transcriptFilePath = meetingFolderPath.resolve(transcriptFileName);

        try (FileWriter fileWriter = new FileWriter(transcriptFilePath.toFile())) {
            fileWriter.write("Transcript for meeting: " + meeting.getTenCuocHop());
        }

        return transcriptFilePath.toString();
    }

}



