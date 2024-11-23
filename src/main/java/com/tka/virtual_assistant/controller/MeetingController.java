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
        String result = meetingService.createMeeting(createMeetingDTO);

        if (result.equals("Cuộc họp được tạo thành công")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PutMapping("/start/{id}")
    public ResponseEntity<String> startMeeting(@PathVariable Long id) {
        String message = meetingService.startMeeting(id);

        if (message.equals("Cuộc họp đã bắt đầu.") || message.equals("Chưa đến thời gian bắt đầu cuộc họp.")) {
            return ResponseEntity.ok(message);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @PutMapping("/end/{id}")
    public ResponseEntity<String> endMeeting(@PathVariable Long id, @RequestParam Long userId) {

        String message = meetingService.endMeeting(id, userId);
        if (message.equals("Cuộc họp đã kết thúc.") || message.equals("Cuộc họp không thể kết thúc vì không đang diễn ra.") || message.equals("Chỉ thư ký mới có thể kết thúc cuộc họp.")) {
            return ResponseEntity.ok(message);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }


    @GetMapping
    public ResponseEntity<List<MeetingDTO>> getAllMeetings() {
        List<MeetingDTO> meetings = meetingService.getAllMeetings();
        if (meetings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(meetings);
    }


}

