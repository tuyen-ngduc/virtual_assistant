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

    Optional<NguoiThamGia> findByMeetingIdAndNhanVienId(long meetingId, long nhanVienId);

    List<NguoiThamGia> findByNhanVienId(Long nhanVienId);

    @Query("""
                SELECT CASE WHEN COUNT(ntg) > 0 THEN TRUE ELSE FALSE END
                FROM NguoiThamGia ntg
                WHERE ntg.nhanVien = :nhanVien
                  AND ((ntg.meeting.thoiGianBatDau < :thoiGianKetThuc AND ntg.meeting.thoiGianKetThuc > :thoiGianBatDau))
            """)
    boolean existsByNhanVienAndThoiGianTrungLich(@Param("nhanVien") NhanVien nhanVien,
                                                 @Param("thoiGianBatDau") LocalDateTime thoiGianBatDau,
                                                 @Param("thoiGianKetThuc") LocalDateTime thoiGianKetThuc);

    @Query("SELECT ntg.meeting.id FROM NguoiThamGia ntg WHERE ntg.nhanVien.id = :nhanVienId")
    List<Long> findMeetingIdsByNhanVienId(@Param("nhanVienId") Long nhanVienId);
}
