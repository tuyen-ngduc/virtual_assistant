package com.tka.virtual_assistant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.virtual_assistant.domain.BoMon;
import com.tka.virtual_assistant.repository.BoMonRepository;

import jakarta.transaction.Transactional;

@Service
public class BoMonService {
    @Autowired
    BoMonRepository boMonRepository;

    public List<BoMon> findAll() {
        return boMonRepository.findAll();
    }

    @Transactional
    public Optional<BoMon> findByMbm(String mbm) {
        return boMonRepository.findByMaBoMon(mbm);
    }

    public BoMon themBoMon(BoMon boMon) {
        return boMonRepository.save(boMon);
    }

    @Transactional
    public void xoaBoMon(String mbm) {
        boMonRepository.deleteByMaBoMon(mbm);
    }
}
