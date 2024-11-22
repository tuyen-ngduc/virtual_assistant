package com.tka.virtual_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tka.virtual_assistant.domain.PhongHop;

import java.util.Optional;

public interface PhongHopRepository extends JpaRepository<PhongHop, Long> {
    Optional<PhongHop> findByTenPhongHop(String tenPhongHop);
}
