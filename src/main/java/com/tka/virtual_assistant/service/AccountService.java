package com.tka.virtual_assistant.service;

import java.util.List;
import java.util.Optional;

import com.tka.virtual_assistant.domain.NhanVien;
import com.tka.virtual_assistant.dto.RegisterDTO;
import com.tka.virtual_assistant.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tka.virtual_assistant.domain.Account;
import com.tka.virtual_assistant.repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final NhanVienRepository nhanVienRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, NhanVienRepository nhanVienRepository) {
        this.accountRepository = accountRepository;
        this.nhanVienRepository = nhanVienRepository;
    }

    public boolean addAccount(RegisterDTO registerDTO) {

        if (!registerDTO.isPasswordMatching()) {
            throw new IllegalArgumentException("Mật khẩu và nhập lại mật khẩu không khớp!");
        }

        Optional<NhanVien> nhanVienOpt = nhanVienRepository.findByMaNhanVien(registerDTO.getMaNhanVien());

        if (nhanVienOpt.isPresent()) {
            Account account = new Account();
            account.setTenTaiKhoan(registerDTO.getUsername());
            account.setPassword(registerDTO.getPassword());
            account.setNhanVien(nhanVienOpt.get());

            try {
                accountRepository.save(account);
                return true;
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()).hasBody();
            }
        } else {
            return false;
        }
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public void delete(long id) {
        accountRepository.deleteById(id);
    }

}
