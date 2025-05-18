package com.tareas.gestor.web.dto;

public class LoginResponse {
    private Integer userId;
    private String nombre;
    private String apellidos;
    private String correo;
    private String mensaje;

    public LoginResponse() {
    }

    public LoginResponse(Integer userId, String nombre, String apellidos, String correo, String mensaje) {
        this.userId = userId;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.mensaje = mensaje;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
