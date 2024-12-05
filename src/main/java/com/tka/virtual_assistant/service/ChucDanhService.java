package com.tka.virtual_assistant.service;

import com.tka.virtual_assistant.domain.ChucDanh;
import com.tka.virtual_assistant.domain.PhongBan;
import com.tka.virtual_assistant.dto.response.ChucDanhDTO;
import com.tka.virtual_assistant.dto.response.PhongBanDTO;
import com.tka.virtual_assistant.repository.ChucDanhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ChucDanhService {
    private final ChucDanhRepository chucDanhRepository;

    public ChucDanhService(ChucDanhRepository chucDanhRepository) {
        this.chucDanhRepository = chucDanhRepository;
    }

    public List<ChucDanhDTO> getDanhSachChucDanh() {
        List<ChucDanh> chucDanhList = chucDanhRepository.findAll(); // Lấy tất cả các chức danh từ DB

        // Chuyển đổi danh sách chức danh thành danh sách ChucDanhDTO
        return chucDanhList.stream()
                .map(c -> new ChucDanhDTO(c.getName()))
                .collect(Collectors.toList());
    }

}
