package com.tka.virtual_assistant.controller;
import com.tka.virtual_assistant.dto.response.ChucDanhDTO;
import com.tka.virtual_assistant.service.ChucDanhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chucdanh")
public class ChucDanhController {

    private final ChucDanhService chucDanhService;

    public ChucDanhController(ChucDanhService chucDanhService) {
        this.chucDanhService = chucDanhService;
    }

    @GetMapping("/list")
    public List<ChucDanhDTO> getDanhSachChucDanh() {
        return chucDanhService.getDanhSachChucDanh();
    }
}
