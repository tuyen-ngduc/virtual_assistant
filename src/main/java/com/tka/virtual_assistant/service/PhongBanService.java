package com.tka.virtual_assistant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.virtual_assistant.domain.PhongBan;
import com.tka.virtual_assistant.repository.PhongBanRepository;

import jakarta.transaction.Transactional;

@Service
public class PhongBanService {
    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<PhongBan> findAll() {
        return phongBanRepository.findAll();
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
