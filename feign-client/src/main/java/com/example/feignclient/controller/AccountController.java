package com.example.feignclient.controller;

import com.example.api.AccountApi;
import com.example.feignclient.clients.AccountClient;
import com.example.model.AccountRequest;
import com.example.model.AccountResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountClient accountClient;

    public AccountController(AccountClient accountClient) {
        this.accountClient = accountClient;
    }

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestParam Long userId,
                                                         @RequestBody AccountRequest account) {
        return accountClient.createAccount(userId, account);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAccountById(@PathVariable Long id) {
        return accountClient.deleteAccountById(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<AccountResponse> findAccountById(@PathVariable Long id) {
        return accountClient.findAccountById(id);
    }

    @GetMapping("all")
    public ResponseEntity<List<AccountResponse>> findAllAccounts() {
        return accountClient.findAllAccounts();
    }

    @PutMapping("{id}")
    public ResponseEntity<AccountResponse> updateAccount(@PathVariable Long id,
                                                         @RequestBody AccountRequest account) {
        return null;
    }
}
