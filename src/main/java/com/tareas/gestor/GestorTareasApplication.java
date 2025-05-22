package com.tareas.gestor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tareas.gestor")
public class GestorTareasApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestorTareasApplication.class, args);
	}
}

