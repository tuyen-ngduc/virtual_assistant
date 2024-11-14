package com.tka.virtual_assistant.service;

import java.util.List;
import java.util.Optional;

import com.tka.virtual_assistant.domain.NhanVien;
import com.tka.virtual_assistant.dto.LoginDTO;
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

    public Optional<String> addAccount(RegisterDTO registerDTO) {
        if (accountRepository.existsByTenTaiKhoan(registerDTO.getUsername())) {
            return Optional.of("Tên tài khoản đã tồn tại");
        }

        Optional<NhanVien> nhanVienOpt = nhanVienRepository.findByMaNhanVien(registerDTO.getMaNhanVien());
        if (!nhanVienOpt.isPresent()) {
            return Optional.of("Mã nhân viên không tồn tại");
        }

        NhanVien nhanVien = nhanVienOpt.get();
        Account account = new Account();
        account.setTenTaiKhoan(registerDTO.getUsername());
        account.setPassword(registerDTO.getPassword());
        account.setNhanVien(nhanVien);

        try {
            accountRepository.save(account);
            return Optional.empty();
        } catch (Exception e) {
            return Optional.of("Lỗi khi tạo tài khoản");
        }
    }


    public Optional<String> loginAccount(LoginDTO loginDTO) {

        Optional<Account> accountOpt = accountRepository.findByTenTaiKhoan(loginDTO.getUsername());

        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            if (account.getPassword().equals(loginDTO.getPassword())) {
                return Optional.empty();
            } else {
                return Optional.of("Mật khẩu không đúng");
            }
        } else {
            return Optional.of("Tên tài khoản không tồn tại");
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
