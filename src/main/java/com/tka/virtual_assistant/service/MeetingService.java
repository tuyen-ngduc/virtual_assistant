package com.tka.virtual_assistant.service;

import com.tka.virtual_assistant.domain.Meeting;
import com.tka.virtual_assistant.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    public Optional<Meeting> getMeetingById(long id) {
        return meetingRepository.findById(id);
    }

    public Meeting createMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    public void deleteMeeting(long id) {
        if (meetingRepository.existsById(id)) {
            meetingRepository.deleteById(id);
        } else {
            throw new RuntimeException("Meeting not found with ID: " + id);
        }
    }

}
