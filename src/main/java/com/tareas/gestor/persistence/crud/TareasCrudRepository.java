package com.tareas.gestor.persistence.crud;

import com.tareas.gestor.persistence.entity.Tareas;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TareasCrudRepository extends CrudRepository<Tareas, Integer> {

    List<Tareas> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Tareas>> findByPrioridadLessThanAndEstado(char prioridad, String estado);

}
