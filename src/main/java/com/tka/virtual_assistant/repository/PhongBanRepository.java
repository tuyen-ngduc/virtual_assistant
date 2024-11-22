package com.tka.virtual_assistant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.virtual_assistant.domain.PhongBan;

public interface PhongBanRepository extends JpaRepository<PhongBan, String> {
    Optional<PhongBan> findByMaPhongBan(String maPhongBan);
    Optional<PhongBan> findByTenPhongBan(String tenPhongBan);

    void deleteByMaPhongBan(String mpb);
}
