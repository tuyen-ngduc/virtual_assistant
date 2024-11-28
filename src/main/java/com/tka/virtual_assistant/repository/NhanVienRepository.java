package com.tka.virtual_assistant.repository;

import java.util.List;
import java.util.Optional;

import com.tka.virtual_assistant.dto.response.NhanVienDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.virtual_assistant.domain.NhanVien;
import org.springframework.data.jpa.repository.Query;

public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
    Optional<NhanVien> findByMaNhanVien(String mnv);
    void deleteByMaNhanVien(String mnv);

        @Query("SELECT new com.tka.virtual_assistant.dto.response.NhanVienDTO(n.maNhanVien, n.tenNhanVien, p.maPhongBan) " +
                "FROM NhanVien n JOIN n.phongBan p")
        List<NhanVienDTO> findAllNhanVienSummary();
    }



