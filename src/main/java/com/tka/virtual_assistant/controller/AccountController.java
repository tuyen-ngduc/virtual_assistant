package com.tka.virtual_assistant.controller;

import com.tka.virtual_assistant.domain.NhanVien;
import com.tka.virtual_assistant.dto.request.LoginDTO;
import com.tka.virtual_assistant.dto.request.RegisterDTO;
import com.tka.virtual_assistant.dto.response.LoginResponse;
import com.tka.virtual_assistant.repository.AccountRepository;
import com.tka.virtual_assistant.repository.NhanVienRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.tka.virtual_assistant.domain.Account;
import com.tka.virtual_assistant.service.AccountService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountRepository accountRepository;
    private final AccountService accountService;
    private final NhanVienRepository nhanVienRepository;

    public AccountController(AccountService accountService, NhanVienRepository nhanVienRepository) {
        this.accountService = accountService;
        this.nhanVienRepository = nhanVienRepository;
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerAccount(@RequestBody RegisterDTO registerDTO) {
        Optional<String> errorMessage = accountService.addAccount(registerDTO);

        if (errorMessage.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.get());
        } else {
            return ResponseEntity.ok("Đăng ký thành công");
        }
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        Optional<String> response = accountService.loginAccount(loginDTO);

        if (response.isPresent() && !response.get().equals("Mật khẩu không đúng") && !response.get().equals("Tên tài khoản không tồn tại")) {
            return ResponseEntity.ok(new LoginResponse(response.get())); // Trả về token
        } else {
            return ResponseEntity.badRequest().body(response.get());
        }
    }
    @GetMapping("/user")
    public ResponseEntity<?> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Lấy tên tài khoản từ SecurityContext


        Optional<Account> accountOpt = accountRepository.findByTenTaiKhoan(username);
        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            NhanVien nhanVien = account.getNhanVien(); // Lấy thông tin nhân viên

            // Trả về thông tin nhân viên dưới dạng JSON hoặc thông tin cần thiết
            return ResponseEntity.ok(nhanVien);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Người dùng không hợp lệ");
        }
    }


    @GetMapping
    public List<Account> getAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getByMaNhanVien(@PathVariable long id) {
        return accountService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
