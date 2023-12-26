package com.dw.securityservice.service;

import com.dw.securityservice.entity.UserDetail;
import com.dw.securityservice.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetail> userDetail = userDetailRepository.findByUsername(username);
        return
                userDetail
                        .map(CustomUserDetails::new)
                        .orElseThrow(() -> new UsernameNotFoundException(username + " not found."));
    }
}
