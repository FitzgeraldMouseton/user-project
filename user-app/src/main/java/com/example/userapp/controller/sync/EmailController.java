package com.example.userapp.controller.sync;

import com.example.api.EmailApi;
import com.example.model.EmailRequest;
import com.example.model.EmailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmailController implements EmailApi {

    @Override
    public ResponseEntity<EmailResponse> createEmail(Long userId, EmailRequest phone) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteEmailById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<EmailResponse>> findAllEmails() {
        return null;
    }

    @Override
    public ResponseEntity<EmailResponse> findEmailById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<EmailResponse> updateEmail(Long id, EmailRequest phone) {
        return null;
    }
}
