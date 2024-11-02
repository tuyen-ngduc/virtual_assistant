package com.tka.virtual_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.virtual_assistant.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
