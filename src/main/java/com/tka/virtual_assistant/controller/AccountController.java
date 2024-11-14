package com.tka.virtual_assistant.controller;

import com.tka.virtual_assistant.domain.NhanVien;
import com.tka.virtual_assistant.dto.RegisterDTO;
import com.tka.virtual_assistant.repository.AccountRepository;
import com.tka.virtual_assistant.repository.NhanVienRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.tka.virtual_assistant.domain.Account;
import com.tka.virtual_assistant.service.AccountService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    private final NhanVienRepository nhanVienRepository;

    public AccountController(AccountService accountService, NhanVienRepository nhanVienRepository) {
        this.accountService = accountService;
        this.nhanVienRepository = nhanVienRepository;
    }


    @PostMapping("/log/register")
    public ResponseEntity<String> registerAccount(@RequestBody RegisterDTO registerDTO) {
        boolean isCreated = accountService.addAccount(registerDTO);

        if (isCreated) {
            return ResponseEntity.ok("Đăng ký tài khoản thành công!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mã nhân viên không tồn tại!");
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

    @PostMapping
    public Account create(@RequestBody Account account) {
        return accountService.save(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
