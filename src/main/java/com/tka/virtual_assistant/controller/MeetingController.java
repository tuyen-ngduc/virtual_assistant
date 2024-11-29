package com.tka.virtual_assistant.controller;

import java.util.List;

import com.tka.virtual_assistant.dto.request.createMeetingDTO;
import com.tka.virtual_assistant.dto.response.MeetingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tka.virtual_assistant.domain.Meeting;
import com.tka.virtual_assistant.service.MeetingService;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createMeeting(@RequestBody createMeetingDTO createMeetingDTO) {
        try {
            String result = meetingService.createMeeting(createMeetingDTO);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<List<MeetingDTO>> getAllMeetings() {
        List<MeetingDTO> meetings = meetingService.getAllMeetings();
        return ResponseEntity.ok(meetings);
    }
//    @PutMapping("/start/{id}")
//    public ResponseEntity<String> startMeeting(@PathVariable Long id) {
//        String message = meetingService.startMeeting(id);
//        if (message.equals("Cuộc họp đã bắt đầu.")) {
//            return ResponseEntity.ok(message);
//        } else if (message.equals("Phòng họp này đã có cuộc họp đang diễn ra.")) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
//        }
//    }
//
//
//    @PutMapping("/end/{id}")
//    public ResponseEntity<String> endMeeting(@PathVariable Long id, @RequestParam Long userId) {
//
//        String message = meetingService.endMeeting(id, userId);
//        if (message.equals("Cuộc họp đã kết thúc.") || message.equals("Cuộc họp không thể kết thúc vì không đang diễn ra.") || message.equals("Chỉ thư ký mới có thể kết thúc cuộc họp.")) {
//            return ResponseEntity.ok(message);
//        }
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
//    }
//
//
//    @GetMapping
//    public ResponseEntity<List<MeetingDTO>> getAllMeetings() {
//        List<MeetingDTO> meetings = meetingService.getAllMeetings();
//        if (meetings.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(meetings);
//    }
//
//
//    @PostMapping("/{meetingId}/addParticipant")
//    public ResponseEntity<String> addParticipant(
//            @PathVariable Long meetingId,
//            @RequestParam Long nhanVienId,
//            @RequestParam String chucDanh,
//            @RequestHeader("userId") Long userIdRequesting) {
//
//        // Gọi service để thêm thành viên vào cuộc họp
//        String response = meetingService.addParticipant(meetingId, nhanVienId, userIdRequesting, chucDanh);
//
//        if (response.equals("Nhân viên đã tham gia cuộc họp thành công!")) {
//            return ResponseEntity.ok(response);
//        } else {
//            return ResponseEntity.badRequest().body(response);
//        }
//    }


}

