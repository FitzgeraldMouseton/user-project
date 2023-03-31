package com.example.userapp.controller.sync;

import com.example.api.PhoneApi;
import com.example.model.PhoneRequest;
import com.example.model.PhoneResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneController implements PhoneApi {

    @Override
    public ResponseEntity<PhoneResponse> createPhone(Long userId, PhoneRequest phone) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deletePhoneById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<PhoneResponse>> findAllPhones() {
        return null;
    }

    @Override
    public ResponseEntity<PhoneResponse> findPhoneById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PhoneResponse> updatePhone(Long id, PhoneRequest phone) {
        return null;
    }
}
