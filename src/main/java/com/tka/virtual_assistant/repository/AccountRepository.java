package com.tka.virtual_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.virtual_assistant.domain.Account;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByTenTaiKhoan(String username);
    Optional<Account> findByTenTaiKhoan(String username);
}
