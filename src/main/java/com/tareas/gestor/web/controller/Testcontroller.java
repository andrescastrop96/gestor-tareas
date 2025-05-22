package com.tareas.gestor.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class Testcontroller {

        @GetMapping("/")
        public String hola() {
            return "Backend funcionando!";
        }
    }
