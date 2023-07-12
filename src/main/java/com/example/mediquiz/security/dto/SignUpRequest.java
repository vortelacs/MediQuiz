package com.example.mediquiz.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequest {

    private String name;
//    private String phone;
    private String email;
    private String password;
}
