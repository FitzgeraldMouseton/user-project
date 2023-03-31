package com.example.feignclient.controller;

import com.example.feignclient.clients.PhoneClient;
import com.example.model.PhoneRequest;
import com.example.model.PhoneResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phones")
public class PhoneController {

    private final PhoneClient phoneClient;

    public PhoneController(PhoneClient phoneClient) {
        this.phoneClient = phoneClient;
    }

    @PostMapping
    public ResponseEntity<PhoneResponse> createPhone(@RequestParam Long userId,
                                                     @RequestBody PhoneRequest phone) {
        return phoneClient.createPhone(userId, phone);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePhoneById(@PathVariable Long id) {
        return phoneClient.deletePhoneById(id);
    }

    @GetMapping("all")
    public ResponseEntity<List<PhoneResponse>> findAllPhones() {
        return phoneClient.findAllPhones();
    }

    @GetMapping("{id}")
    public ResponseEntity<PhoneResponse> findPhoneById(@PathVariable Long id) {
        return phoneClient.findPhoneById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<PhoneResponse> updatePhone(@PathVariable Long id,
                                                     @RequestBody PhoneRequest phone) {
        return phoneClient.updatePhone(id, phone);
    }
}
