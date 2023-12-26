package com.dw.securityservice.controller;

import com.dw.securityservice.request.UserDetailRequest;
import com.dw.securityservice.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserDetailService userDetailService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDetailRequest userDetailRequest) {
        try {
            return userDetailService.registerUser(userDetailRequest);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Unable to register at the moment, please try later.";
        }
    }
}
