package com.awy.progettofinalespringboot.features.utente;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String username;
    private String password;
}
