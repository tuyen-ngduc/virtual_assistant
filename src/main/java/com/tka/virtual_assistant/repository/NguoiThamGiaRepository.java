package com.tka.virtual_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.virtual_assistant.domain.Meeting;
import com.tka.virtual_assistant.domain.NguoiThamGia;
import java.util.List;

public interface NguoiThamGiaRepository extends JpaRepository<NguoiThamGia, Long> {
    List<NguoiThamGia> findByMeeting(Meeting meeting);
}
