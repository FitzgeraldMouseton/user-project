package com.example.userapp.controller.sync;

import com.example.api.AccountApi;
import com.example.model.AccountRequest;
import com.example.model.AccountResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController implements AccountApi {

    @Override
    public ResponseEntity<AccountResponse> createAccount(Long userId, AccountRequest account) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteAccountById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<AccountResponse> findAccountById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<AccountResponse>> findAllAccounts() {
        return null;
    }

    @Override
    public ResponseEntity<AccountResponse> updateAccount(Long id, AccountRequest account) {
        return null;
    }
}
