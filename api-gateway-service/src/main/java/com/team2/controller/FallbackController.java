package com.team2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/fallback")
@RestController
public class FallbackController {
    @GetMapping("/authservice")
    public ResponseEntity<String> authServiceFallback() {
        return ResponseEntity.ok("Auth service is currently unavailable.");
    }
    @GetMapping("/userservice")
    public ResponseEntity<String> userServiceFallback() {
        return ResponseEntity.ok("User service is currently unavailable.");
    }
    @GetMapping("/leaveservice")
    public ResponseEntity<String> leaveServiceFallback() {
        return ResponseEntity.ok("Leave service is currently unavailable.");
    }
    @GetMapping("/companyservice")
    public ResponseEntity<String> companyServiceFallback() {
        return ResponseEntity.ok("Company service is currently unavailable.");
    }
    @GetMapping("/emailservice")
    public ResponseEntity<String> emailServiceFallback() {
        return ResponseEntity.ok("Email service is currently unavailable.");
    }
}

