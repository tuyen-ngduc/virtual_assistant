package com.tka.virtual_assistant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.virtual_assistant.domain.PhongHop;
import com.tka.virtual_assistant.repository.PhongHopRepository;

import jakarta.transaction.Transactional;

@Service
public class PhongHopService {
    @Autowired
    PhongHopRepository phongHopRepository;

    public List<PhongHop> findALl() {
        return phongHopRepository.findAll();
    }

    public Optional<PhongHop> findById(Long id) {
        return phongHopRepository.findById(id);
    }

    public PhongHop themPhongHop(PhongHop phongHop) {
        return phongHopRepository.save(phongHop);

    }

    @Transactional
    public void xoaPhongHop(Long id) {
        phongHopRepository.deleteById(id);
    }
}
