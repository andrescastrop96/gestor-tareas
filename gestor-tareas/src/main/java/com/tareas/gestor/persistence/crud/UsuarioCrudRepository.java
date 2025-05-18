package com.tareas.gestor.persistence.crud;

import com.tareas.gestor.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {
    // Puedes agregar más métodos personalizados si los necesitas después.
}
