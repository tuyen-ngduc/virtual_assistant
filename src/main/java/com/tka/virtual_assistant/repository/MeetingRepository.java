package com.tka.virtual_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.virtual_assistant.domain.Meeting;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

}
