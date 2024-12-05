package com.tka.virtual_assistant.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tka.virtual_assistant.dto.response.PhongBanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.virtual_assistant.domain.PhongBan;
import com.tka.virtual_assistant.repository.PhongBanRepository;

import jakarta.transaction.Transactional;

@Service
public class PhongBanService {
    private final PhongBanRepository phongBanRepository;

    public PhongBanService(PhongBanRepository phongBanRepository) {
        this.phongBanRepository = phongBanRepository;
    }

    public List<PhongBan> findAll() {
        return phongBanRepository.findAll();
    }

    public List<PhongBanDTO> getDanhSachPhongBan() {
        List<PhongBan> phongBanList = phongBanRepository.findAll(); // Lấy tất cả các phòng ban từ DB

        // Chuyển đổi danh sách phòng ban thành danh sách PhongBanDTO
        return phongBanList.stream()
                .map(p -> new PhongBanDTO(p.getTenPhongBan()))
                .collect(Collectors.toList());
    }

    @Transactional
    public Optional<PhongBan> findByMpb(String mpb) {
        return phongBanRepository.findByMaPhongBan(mpb);
    }

    public PhongBan themPhongBan(PhongBan phongBan) {
        return phongBanRepository.save(phongBan);
    }

    @Transactional
    public void xoaPhongBan(String mpb) {
        phongBanRepository.deleteByMaPhongBan(mpb);
    }
}
