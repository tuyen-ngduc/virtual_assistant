package com.tka.virtual_assistant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.virtual_assistant.domain.PhongBan;
import com.tka.virtual_assistant.service.PhongBanService;

@RestController
@RequestMapping("/phongban")
public class PhongBanController {
    @Autowired
    PhongBanService phongBanService;

    @GetMapping
    public List<PhongBan> getAll() {
        return phongBanService.findAll();
    }

    @GetMapping("/{mpb}")
    public ResponseEntity<PhongBan> getByMpb(@PathVariable String mpb) {
        return phongBanService.findByMpb(mpb)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PhongBan create(@RequestBody PhongBan phongBan) {
        return phongBanService.themPhongBan(phongBan);
    }

    @DeleteMapping("/{mpb}")
    public ResponseEntity<Void> delete(@PathVariable String mpb) {
        phongBanService.xoaPhongBan(mpb);
        return ResponseEntity.noContent().build();

    }
}
