package com.awy.progettofinalespringboot.features.utente;

import com.awy.progettofinalespringboot.features.utente.LoginRequestDTO;
import com.awy.progettofinalespringboot.features.utente.RegisterRequestDTO;
import com.awy.progettofinalespringboot.features.utente.UtenteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UtenteController {

    private final UtenteService utenteService;

    @PostMapping("/register")
    public UtenteResponseDTO register(@RequestBody RegisterRequestDTO dto) {
        return utenteService.register(dto);
    }

    @PostMapping("/login")
    public UtenteResponseDTO login(@RequestBody LoginRequestDTO dto) {
        return utenteService.login(dto);
    }
}
