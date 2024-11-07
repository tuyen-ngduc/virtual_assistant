package com.tka.virtual_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.virtual_assistant.domain.FileTranscript;

public interface FileTranscriptRepository extends JpaRepository<FileTranscript, Long> {

}
