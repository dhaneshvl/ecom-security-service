package com.dw.securityservice.service;

import com.dw.securityservice.repository.UserDetailRepository;
import com.dw.securityservice.request.AuthenticationRequest;
import com.dw.securityservice.request.UserDetailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String generateToken(AuthenticationRequest authenticationRequest) throws Exception {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(authenticationRequest.getUsername());
        } else {
            throw new RuntimeException("Unauthorized access");
        }

    }

    public Boolean validateToken(String token, UserDetailRequest userDetailRequest) {
        return jwtService.validateToken(token, userDetailRequest);
    }

    public Boolean validateToken(String token) {
        return jwtService.validateToken(token);
    }
}
