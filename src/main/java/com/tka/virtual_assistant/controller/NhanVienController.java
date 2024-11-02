package com.tka.virtual_assistant.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tka.virtual_assistant.domain.NhanVien;
import com.tka.virtual_assistant.service.NhanVienService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/nhanvien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public List<NhanVien> getAll() {
        return nhanVienService.findAll();
    }

    @GetMapping("/{mnv}")
    public ResponseEntity<NhanVien> getByMnv(@PathVariable String mnv) {
        return nhanVienService.findByMnv(mnv)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NhanVien create(@RequestBody NhanVien nhanvien) {
        return nhanVienService.save(nhanvien);
    }

    @DeleteMapping("/{mnv}")
    public ResponseEntity<Void> deletebyMaNhanVien(@PathVariable String mnv) {
        nhanVienService.delete(mnv);
        return ResponseEntity.noContent().build();
    }

}
