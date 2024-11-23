package com.tka.virtual_assistant.service;

import com.tka.virtual_assistant.domain.Meeting;
import com.tka.virtual_assistant.domain.NhanVien;
import com.tka.virtual_assistant.domain.PhongBan;
import com.tka.virtual_assistant.domain.PhongHop;
import com.tka.virtual_assistant.dto.request.createMeetingDTO;
import com.tka.virtual_assistant.dto.response.MeetingDTO;
import com.tka.virtual_assistant.enums.Status;
import com.tka.virtual_assistant.repository.MeetingRepository;
import com.tka.virtual_assistant.repository.NhanVienRepository;
import com.tka.virtual_assistant.repository.PhongBanRepository;
import com.tka.virtual_assistant.repository.PhongHopRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


@Service
public class MeetingService {

    private final MeetingRepository meetingRepository;
    private final PhongBanRepository phongBanRepository;
    private final PhongHopRepository phongHopRepository;
    private final NhanVienRepository nhanVienRepository;

    public MeetingService(
            MeetingRepository meetingRepository,
            PhongBanRepository phongBanRepository,
            PhongHopRepository phongHopRepository,
            NhanVienRepository nhanVienRepository) {
        this.meetingRepository = meetingRepository;
        this.phongBanRepository = phongBanRepository;
        this.phongHopRepository = phongHopRepository;
        this.nhanVienRepository = nhanVienRepository;
    }

    public String createMeeting(createMeetingDTO createMeetingDTO) {
        // Kiểm tra phòng ban
        Optional<PhongBan> phongBanOptional = phongBanRepository.findByTenPhongBan(createMeetingDTO.getTenPhongBan());
        if (phongBanOptional.isEmpty()) {
            return "Phòng ban không tồn tại: " + createMeetingDTO.getTenPhongBan();
        }

        // Kiểm tra phòng họp
        Optional<PhongHop> phongHopOptional = phongHopRepository.findByTenPhongHop(createMeetingDTO.getTenPhongHop());
        if (phongHopOptional.isEmpty()) {
            return "Phòng họp không tồn tại: " + createMeetingDTO.getTenPhongHop();
        }

        // Kiểm tra Chủ tịch
        Optional<NhanVien> chuTichOptional = nhanVienRepository.findByMaNhanVien(createMeetingDTO.getMaChuTich());
        if (chuTichOptional.isEmpty()) {
            return "Mã Chủ tịch không tồn tại: " + createMeetingDTO.getMaChuTich();
        }

        // Kiểm tra Thư ký
        Optional<NhanVien> thuKyOptional = nhanVienRepository.findByMaNhanVien(createMeetingDTO.getMaThuKy());
        if (thuKyOptional.isEmpty()) {
            return "Mã Thư ký không tồn tại: " + createMeetingDTO.getMaThuKy();
        }


        Meeting meeting = new Meeting();
        meeting.setTenCuocHop(createMeetingDTO.getTenCuocHop());
        meeting.setMaGoiNho(createMeetingDTO.getMaGoiNho());
        meeting.setThoiGianBatDau(createMeetingDTO.getThoiGian());
        meeting.setPhongBan(phongBanOptional.get());
        meeting.setPhongHop(phongHopOptional.get());
        meeting.setChuTich(chuTichOptional.get());
        meeting.setThuKy(thuKyOptional.get());
        meeting.setStatus(Status.UPCOMING);
        meetingRepository.save(meeting);

        return "Cuộc họp được tạo thành công";
    }

    public String startMeeting(Long meetingId) {
        Optional<Meeting> meetingOptional = meetingRepository.findById(meetingId);

        if (!meetingOptional.isPresent()) {
            return "Không tìm thấy cuộc họp.";
        }

        Meeting meeting = meetingOptional.get();

        // Kiểm tra trạng thái và thời gian hợp lệ
        Date currentTime = new Date();
        if (meeting.getStatus() != Status.UPCOMING) {
            return "Cuộc họp không ở trạng thái sẵn sàng để bắt đầu.";
        }

        if (meeting.getThoiGianBatDau().after(currentTime)) {
            return "Chưa đến thời gian bắt đầu cuộc họp.";
        }

        // Cập nhật trạng thái và thời gian bắt đầu
        meeting.setThoiGianBatDau(meeting.getThoiGianBatDau());
        meeting.setStatus(Status.ONGOING); // Cập nhật trạng thái
        meetingRepository.save(meeting);

        return "Cuộc họp đã bắt đầu.";
    }

    public String endMeeting(Long meetingId, Long userId) {
        Optional<Meeting> meetingOptional = meetingRepository.findById(meetingId);

        if (!meetingOptional.isPresent()) {
            return "Không tìm thấy cuộc họp.";
        }

        Meeting meeting = meetingOptional.get();

        // Kiểm tra trạng thái cuộc họp
        if (meeting.getStatus() != Status.ONGOING) {
            return "Cuộc họp không thể kết thúc vì không đang diễn ra.";
        }

        // Kiểm tra nếu người yêu cầu kết thúc cuộc họp có phải là thư ký không
        if (!meeting.getThuKy().getId().equals(userId)) {
            return "Chỉ thư ký mới có thể kết thúc cuộc họp.";
        }

        // Cập nhật thời gian kết thúc và trạng thái cuộc họp
        Date currentTime = new Date();
        meeting.setThoiGianKetThuc(currentTime); // Cập nhật thời gian kết thúc
        meeting.setStatus(Status.COMPLETED); // Cập nhật trạng thái thành đã kết thúc
        meetingRepository.save(meeting); // Lưu lại thay đổi

        return "Cuộc họp đã kết thúc.";
    }

    public List<MeetingDTO> getAllMeetings() {
        // Lấy tất cả cuộc họp từ cơ sở dữ liệu
        List<Meeting> meetings = meetingRepository.findAll();

        // Chuyển đổi các cuộc họp thành MeetingDTO
        List<MeetingDTO> meetingDTOList = meetings.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return meetingDTOList;
    }

    // Chuyển đối tượng Meeting thành MeetingDTO
    private MeetingDTO convertToDTO(Meeting meeting) {
        MeetingDTO meetingDTO = new MeetingDTO();

        PhongBan phongBan = meeting.getPhongBan();  // Lấy phòng ban từ Meeting
        meetingDTO.setPhongBan(phongBan != null ? phongBan.getTenPhongBan() : "Unknown");

        PhongHop phongHop = meeting.getPhongHop();
        meetingDTO.setPhongHop(phongHop != null ? phongHop.getTenPhongHop() : "Unknown");

        NhanVien thuKy = meeting.getThuKy();
        meetingDTO.setNguoiTao(thuKy != null ? thuKy.getTenNhanVien() : "Unknown");

        // Thời gian bắt đầu cuộc họp
        Date thoiGianBatDau = meeting.getThoiGianBatDau();
        meetingDTO.setThoiGianBatDau(thoiGianBatDau != null ? thoiGianBatDau : null);


        meetingDTO.setTenCuocHop(meeting.getTenCuocHop());
        meetingDTO.setStatus(meeting.getStatus().toString());
        meetingDTO.setMaGoiNho(meeting.getMaGoiNho());
        meetingDTO.setFileTranscript(meeting.getFileTranscript());

        return meetingDTO;
    }

    //        // Tính thời gian cuộc họp
//        long durationMinutes = calculateMeetingDuration(meeting);
//        meetingDTO.setThoiGian(durationMinutes + " minutes");
    // Tính thời gian cuộc họp (Tính bằng phút)
    private long calculateMeetingDuration(Meeting meeting) {
        if (meeting.getThoiGianKetThuc() != null && meeting.getThoiGianBatDau() != null) {
            long duration = meeting.getThoiGianKetThuc().getTime() - meeting.getThoiGianBatDau().getTime();
            return TimeUnit.MILLISECONDS.toMinutes(duration);
        }
        return 0;
    }





    }







