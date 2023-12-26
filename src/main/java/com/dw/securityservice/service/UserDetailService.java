package com.dw.securityservice.service;

import com.dw.securityservice.entity.UserDetail;
import com.dw.securityservice.repository.UserDetailRepository;
import com.dw.securityservice.request.UserDetailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(UserDetailRequest userDetailRequest) throws Exception {
        userDetailRepository.save(new UserDetail(userDetailRequest.getUsername(), userDetailRequest.getEmail(), passwordEncoder.encode(userDetailRequest.getPassword())));
        return "User has been added successfully";
    }
}
