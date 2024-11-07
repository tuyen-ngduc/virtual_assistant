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

import com.tka.virtual_assistant.domain.PhongHop;
import com.tka.virtual_assistant.service.PhongHopService;

@RestController
@RequestMapping("/api/phonghop")
public class PhongHopController {
    @Autowired
    PhongHopService phongHopService;

    @GetMapping
    public List<PhongHop> getAll() {
        return phongHopService.findALl();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhongHop> getById(@PathVariable Long id) {
        return phongHopService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public PhongHop save(@RequestBody PhongHop phongHop) {
        return phongHopService.themPhongHop(phongHop);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PhongHop> delete(@PathVariable Long id) {
        phongHopService.xoaPhongHop(id);
        return ResponseEntity.noContent().build();
    }

}
