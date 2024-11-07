package com.tka.virtual_assistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.virtual_assistant.domain.NhanVien;
import com.tka.virtual_assistant.repository.NhanVienRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    @Transactional
    public Optional<NhanVien> findByMnv(String mnv) {
        return nhanVienRepository.findByMaNhanVien(mnv);
    }

    public NhanVien save(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    @Transactional
    public void delete(String mnv) {
        nhanVienRepository.deleteByMaNhanVien(mnv);
    }
}
