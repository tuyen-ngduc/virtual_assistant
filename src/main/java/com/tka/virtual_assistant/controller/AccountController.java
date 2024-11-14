package com.tka.virtual_assistant.controller;

import com.tka.virtual_assistant.domain.NhanVien;
import com.tka.virtual_assistant.dto.LoginDTO;
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
    public ResponseEntity<String> loginAccount(@RequestBody LoginDTO loginDTO) {
        Optional<String> errorMessage = accountService.loginAccount(loginDTO);

        if (errorMessage.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.get());
        } else {
            return ResponseEntity.ok("Đăng nhập thành công");
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
