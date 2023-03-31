package com.example.feignclient.controller;

import com.example.api.EmailApi;
import com.example.feignclient.clients.EmailClient;
import com.example.model.EmailRequest;
import com.example.model.EmailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("emails")
public class EmailController {

    private EmailClient emailClient;

    public EmailController(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    @PostMapping
    public ResponseEntity<EmailResponse> createEmail(@RequestParam Long userId,
                                                     @RequestBody EmailRequest email) {
        return emailClient.createEmail(userId, email);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEmailById(@PathVariable Long id) {
        return emailClient.deleteEmailById(id);
    }

    @GetMapping("all")
    public ResponseEntity<List<EmailResponse>> findAllEmails() {
        return emailClient.findAllEmails();
    }

    @GetMapping("{id}")
    public ResponseEntity<EmailResponse> findEmailById(@PathVariable Long id) {
        return emailClient.findEmailById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmailResponse> updateEmail(@PathVariable Long id,
                                                     @RequestBody EmailRequest email) {
        return emailClient.updateEmail(id, email);
    }
}
