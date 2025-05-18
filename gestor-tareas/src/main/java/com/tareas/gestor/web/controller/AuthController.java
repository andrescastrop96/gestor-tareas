package com.tareas.gestor.web.controller;

import com.tareas.gestor.domain.service.AuthService;
import com.tareas.gestor.web.dto.LoginRequest;
import com.tareas.gestor.web.dto.LoginResponse;
import com.tareas.gestor.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return authService.login(request)
                .map(response -> ResponseEntity.ok().body(response))
                .orElseGet(() -> ResponseEntity
                        .status(401)
                        .body(new LoginResponse(null, null, null, null, "Correo o contraseña incorrectos")));
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody RegisterRequest request) {
        LoginResponse response = authService.register(request);
        return ResponseEntity.ok(response);
    }
}

