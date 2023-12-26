package com.dw.securityservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
}
