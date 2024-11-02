package com.tka.virtual_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.virtual_assistant.domain.NguoiThamGia;
import com.tka.virtual_assistant.domain.NguoiThamGiaId;

public interface NguoiThamGiaRepository extends JpaRepository<NguoiThamGia, NguoiThamGiaId> {

}
