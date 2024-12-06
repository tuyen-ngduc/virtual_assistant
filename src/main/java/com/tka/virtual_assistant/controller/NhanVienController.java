package com.tka.virtual_assistant.controller;

import com.tka.virtual_assistant.dto.response.NhanVienDTO;
import com.tka.virtual_assistant.repository.NhanVienRepository;
import com.tka.virtual_assistant.service.AccountService;
import org.springframework.web.bind.annotation.*;

import com.tka.virtual_assistant.domain.NhanVien;
import com.tka.virtual_assistant.service.NhanVienService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/nhanvien")
public class NhanVienController {
    private final NhanVienService nhanVienService;


    private final AccountService accountService;

    public NhanVienController(AccountService accountService, NhanVienService nhanVienService) {
        this.accountService = accountService;
        this.nhanVienService = nhanVienService;
    }

    @GetMapping("/me")
    public ResponseEntity<NhanVien> getCurrentNhanVien(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7); // Loại bỏ "Bearer "
        NhanVien nhanVien = accountService.getNhanVienFromToken(token);
        return ResponseEntity.ok(nhanVien);
    }
    @Autowired
    private NhanVienRepository nhanVienRepository;



    @GetMapping
    public List<NhanVien> getAll() {
        return nhanVienService.findAll();
    }

    @GetMapping("/summary")
    public ResponseEntity<List<NhanVienDTO>> getNhanVienSummary() {
        return ResponseEntity.ok(nhanVienRepository.findAllNhanVienSummary());
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
