package com.tka.virtual_assistant.repository;

import com.tka.virtual_assistant.domain.ChucDanh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChucDanhRepository extends JpaRepository<ChucDanh, Long> {
    Optional<ChucDanh> findByName(String roleName);


}