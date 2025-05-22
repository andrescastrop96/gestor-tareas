package com.tareas.gestor.domain.service;

import com.tareas.gestor.domain.User;
import com.tareas.gestor.persistence.UsuarioRepository;
import com.tareas.gestor.web.dto.LoginRequest;
import com.tareas.gestor.web.dto.LoginResponse;
import com.tareas.gestor.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<LoginResponse> login(LoginRequest request) {
        return usuarioRepository
                .getAll()
                .stream()
                .filter(u -> u.getEmail().equals(request.getEmail())
                        && u.getPassword().equals(request.getPassword()))
                .findFirst()
                .map(user -> new LoginResponse(
                        user.getUserId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        "Inicio de sesión exitoso"
                ));
    }

    public LoginResponse register(RegisterRequest request) {
        // Validar dominio del correo
        if (!request.getEmail().endsWith("@poligran.edu.co")) {
            return new LoginResponse(null, null, null, null, "❌ Solo se permiten correos de dominio @poligran.edu.co");
        }

        // Validar si el correo ya existe
        Optional<User> existingUser = usuarioRepository.getByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            return new LoginResponse(null, null, null, null, "❌ El correo ya está registrado");
        }

        // Crear y guardar nuevo usuario
        User newUser = new User();
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(request.getPassword());
        newUser.setActive(true);

        User savedUser = usuarioRepository.save(newUser);

        return new LoginResponse(
                savedUser.getUserId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail(),
                "✅ Usuario registrado exitosamente"
        );
    }
}
