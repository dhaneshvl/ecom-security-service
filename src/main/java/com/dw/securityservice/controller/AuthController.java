package com.dw.securityservice.controller;

import com.dw.securityservice.request.AuthenticationRequest;
import com.dw.securityservice.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/token")
    public Map<String, String> generateToken(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            return Map.of("JWT_TOKEN", authenticationService.generateToken(authenticationRequest));
        } catch (Exception ex) {
            ex.printStackTrace();
            return Map.of("Error", ex.getMessage());
        }
    }

    @GetMapping("/validate/{token}")
    public ResponseEntity<String> validateToken(@PathVariable String token) {
        if (!authenticationService.validateToken(token)) {
            return new ResponseEntity<>("Invalid or expired token. Please authenticate again.", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>("Token valid", HttpStatus.OK);
    }

}
