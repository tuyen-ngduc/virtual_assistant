package com.tka.virtual_assistant.service;

import java.util.List;
import java.util.Optional;

import com.tka.virtual_assistant.config.JwtUtil;
import com.tka.virtual_assistant.domain.NhanVien;
import com.tka.virtual_assistant.dto.request.LoginDTO;
import com.tka.virtual_assistant.dto.request.RegisterDTO;
import com.tka.virtual_assistant.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.virtual_assistant.domain.Account;
import com.tka.virtual_assistant.repository.AccountRepository;

@Service
public class AccountService {

    private final JwtUtil jwtUtil;
    private final AccountRepository accountRepository;
    private final NhanVienRepository nhanVienRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, NhanVienRepository nhanVienRepository, JwtUtil jwtUtil) {
        this.accountRepository = accountRepository;
        this.nhanVienRepository = nhanVienRepository;
        this.jwtUtil = jwtUtil;
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
                // Tạo token
                String token = jwtUtil.generateToken(account.getTenTaiKhoan());
                return Optional.of(token);
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
