package com.tareas.gestor.web.controller;

import com.tareas.gestor.domain.service.AuthService;
import com.tareas.gestor.web.dto.LoginRequest;
import com.tareas.gestor.web.dto.LoginResponse;
import com.tareas.gestor.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("AuthController activo");
    }

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
    public ResponseEntity<LoginResponse> register(@Valid @RequestBody RegisterRequest request) {
        LoginResponse response = authService.register(request);

        // Si el registro no fue exitoso, devolvemos un error 400
        if (response.getUserId() == null) {
            return ResponseEntity
                    .badRequest()
                    .body(response); // El mensaje de error ya va incluido en el response
        }

        // Si fue exitoso, devolvemos 200 OK
        return ResponseEntity.ok(response);
    }

}

