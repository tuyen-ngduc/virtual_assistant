package com.tka.virtual_assistant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.virtual_assistant.domain.NhanVien;

public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {

    Optional<NhanVien> findByMaNhanVien(String mnv);

    void deleteByMaNhanVien(String mnv);

}
