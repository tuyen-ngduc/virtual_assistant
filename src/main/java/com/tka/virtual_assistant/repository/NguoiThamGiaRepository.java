package com.tka.virtual_assistant.repository;

import com.tka.virtual_assistant.domain.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.virtual_assistant.domain.Meeting;
import com.tka.virtual_assistant.domain.NguoiThamGia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface NguoiThamGiaRepository extends JpaRepository<NguoiThamGia, Long> {
    List<NguoiThamGia> findByMeeting(Meeting meeting);
    List<NguoiThamGia> findByNhanVien(NhanVien nhanvien);
    Optional<NguoiThamGia> findByMeetingIdAndNhanVienId(long meetingId,long nhanVienId);

    List<NguoiThamGia> findByNhanVienId(Long nhanVienId);
    @Query("SELECT nt FROM NguoiThamGia nt WHERE nt.nhanVien.id = :nhanVienId AND " +
            "((:startTime BETWEEN nt.meeting.thoiGianBatDau AND nt.meeting.thoiGianKetThuc) OR " +
            "(:endTime BETWEEN nt.meeting.thoiGianBatDau AND nt.meeting.thoiGianKetThuc) OR " +
            "(nt.meeting.thoiGianBatDau BETWEEN :startTime AND :endTime))")
    List<NguoiThamGia> findByNhanVienAndTime(@Param("nhanVienId") Long nhanVienId,
                                             @Param("startTime") LocalDateTime startTime,
                                             @Param("endTime") LocalDateTime endTime);

}
