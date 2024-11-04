package com.tka.virtual_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.virtual_assistant.domain.BoMon;
import java.util.Optional;

public interface BoMonRepository extends JpaRepository<BoMon, String> {
    Optional<BoMon> findByMaBoMon(String maBoMon);

    void deleteByMaBoMon(String maBoMon);
}
