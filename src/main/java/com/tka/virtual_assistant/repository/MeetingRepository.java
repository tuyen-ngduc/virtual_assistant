package com.tka.virtual_assistant.repository;

import com.tka.virtual_assistant.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.virtual_assistant.domain.Meeting;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> findByStatusIn(List<Status> statuses);
    List<Meeting> findByStatus(Status status);
}
