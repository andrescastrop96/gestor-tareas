package com.tareas.gestor.persistence.crud;

import com.tareas.gestor.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByCorreoElectronico(String correoElectronico);


}

