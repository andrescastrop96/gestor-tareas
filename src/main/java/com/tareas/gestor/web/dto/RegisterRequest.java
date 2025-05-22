package com.tareas.gestor.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class RegisterRequest {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String firstName;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String lastName;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "Debe ser un correo válido")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@poligran\\.edu\\.co$",
            message = "El correo debe ser del dominio @poligran.edu.co"
    )
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;

    // Getters y Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
