package com.awy.progettofinalespringboot.features.utente;

import com.awy.progettofinalespringboot.features.utente.LoginRequestDTO;
import com.awy.progettofinalespringboot.features.utente.RegisterRequestDTO;
import com.awy.progettofinalespringboot.features.utente.UtenteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", ex.getMessage());

        HttpStatus status = HttpStatus.BAD_REQUEST; // Default 400


        if ("Password errata".equals(ex.getMessage()) || "Utente non registrato.".equals(ex.getMessage())) {
            status = HttpStatus.UNAUTHORIZED; // 401
        } else if ("Username già esistente.".equals(ex.getMessage())) {
            status = HttpStatus.CONFLICT; // 409
        }

        return new ResponseEntity<>(errorMap, status);
    }
}