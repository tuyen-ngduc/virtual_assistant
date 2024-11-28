package com.tka.virtual_assistant.service;

import com.tka.virtual_assistant.domain.*;
import com.tka.virtual_assistant.dto.request.createMeetingDTO;
import com.tka.virtual_assistant.enums.Status;
import com.tka.virtual_assistant.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;

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
            meeting.setPhongBan(phongBan);
            meeting.setPhongHop(phongHop);
            meeting.setChuTich(chuTich);
            meeting.setThuKy(thuKy);
            meeting.setStatus(Status.UPCOMING);

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

            return "Cuộc họp được tạo thành công.";
        }
    }



