package com.tka.virtual_assistant.repository;

import com.tka.virtual_assistant.domain.NguoiThamGia;
import com.tka.virtual_assistant.domain.PhongHop;
import com.tka.virtual_assistant.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.virtual_assistant.domain.Meeting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    @Query("SELECT m FROM meeting m WHERE m.phongHop.ID_PhongHop = :phongHopId AND " +
            "((:startTime BETWEEN m.thoiGianBatDau AND m.thoiGianKetThuc) OR " +
            "(:endTime BETWEEN m.thoiGianBatDau AND m.thoiGianKetThuc) OR " +
            "(m.thoiGianBatDau BETWEEN :startTime AND :endTime))")
    List<Meeting> findMeetingsByPhongHopAndTime(@Param("phongHopId") Long phongHopId,
                                                @Param("startTime") LocalDateTime startTime,
                                                @Param("endTime") LocalDateTime  endTime);

    Optional<Meeting> findById(Long id);


}
