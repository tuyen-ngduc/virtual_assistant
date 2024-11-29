package com.tka.virtual_assistant.service;

import com.tka.virtual_assistant.domain.Meeting;
import com.tka.virtual_assistant.domain.NguoiThamGia;
import com.tka.virtual_assistant.repository.NguoiThamGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NguoiThamGiaService {

    private final NguoiThamGiaRepository nguoiThamGiaRepository;

    public NguoiThamGiaService(NguoiThamGiaRepository nguoiThamGiaRepository) {
        this.nguoiThamGiaRepository = nguoiThamGiaRepository;
    }


    public List<NguoiThamGia> getAllParticipantsByMeeting(Meeting meeting) {
        return nguoiThamGiaRepository.findByMeeting(meeting);
    }

    
    public Optional<NguoiThamGia> getParticipantById(Long id) {
        return nguoiThamGiaRepository.findById(id);
    }

   
    public NguoiThamGia addParticipant(NguoiThamGia nguoiThamGia) {
        return nguoiThamGiaRepository.save(nguoiThamGia);
    }


    public void deleteParticipant(long id) {
        nguoiThamGiaRepository.deleteById(id);
    }
}
