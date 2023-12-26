package com.dw.securityservice.repository;

import com.dw.securityservice.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail,Long> {
    Optional<UserDetail> findByUsername(String username);
}
