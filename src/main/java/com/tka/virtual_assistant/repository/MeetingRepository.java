package com.tka.virtual_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.virtual_assistant.domain.Meeting;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

}
