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

import com.tka.virtual_assistant.domain.BoMon;
import com.tka.virtual_assistant.service.BoMonService;

@RestController
@RequestMapping("/api/bomon")
public class BoMonController {
    @Autowired
    BoMonService boMonService;

    @GetMapping
    public List<BoMon> getAll() {
        return boMonService.findAll();
    }

    @GetMapping("/{mbm}")
    public ResponseEntity<BoMon> getByMaBoMon(@PathVariable String mbm) {
        return boMonService.findByMbm(mbm)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BoMon create(@RequestBody BoMon boMon) {
        return boMonService.themBoMon(boMon);

    }

    @DeleteMapping("/{mbm}")
    public ResponseEntity<Void> delete(@PathVariable String mbm) {
        boMonService.xoaBoMon(mbm);
        return ResponseEntity.noContent().build();

    }
}
