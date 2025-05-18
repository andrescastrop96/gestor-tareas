package com.tareas.gestor.persistence.mapper;

import com.tareas.gestor.domain.Task;
import com.tareas.gestor.persistence.entity.Tareas;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mappings({
            @Mapping(source = "idTareas", target = "taskId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "fechaCreacion", target = "creationDate"),
            @Mapping(source = "fechaVencimiento", target = "expirationDate"),
            @Mapping(source = "prioridad", target = "priority"),
            @Mapping(source = "estado", target = "status"),
            @Mapping(source = "idUsuario", target = "userId") // 👈🏽 este es nuevo
    })
    Task toTask(Tareas tarea);

    List<Task> toTasks(List<Tareas> tareas);

    @InheritInverseConfiguration
    Tareas toTareas(Task task);
}
