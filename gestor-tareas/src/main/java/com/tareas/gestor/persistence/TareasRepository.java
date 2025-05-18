package com.tareas.gestor.persistence;

import com.tareas.gestor.domain.Task;
import com.tareas.gestor.domain.repository.TaskRepository;
import com.tareas.gestor.persistence.crud.TareasCrudRepository;
import com.tareas.gestor.persistence.entity.Tareas;
import com.tareas.gestor.persistence.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TareasRepository implements TaskRepository {

    @Autowired
    private TareasCrudRepository tareasCrudRepository;

    @Autowired
    private TaskMapper mapper;

    @Override
    public List<Task> getAll() {
        List<Tareas> tareas = (List<Tareas>) tareasCrudRepository.findAll();
        return mapper.toTasks(tareas);
    }

    @Override
    public Optional<List<Task>> getByCategory(int categoryId) {
        List<Tareas> tareas = tareasCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toTasks(tareas));
    }

    @Override
    public Optional<List<Task>> getByPriority(char priority) {
        Optional<List<Tareas>> tareas = tareasCrudRepository.findByPrioridadLessThanAndEstado(priority, "Pendiente");
        return tareas.map(mapper::toTasks);
    }

    @Override
    public Optional<Task> getTask(int taskId) {
        return tareasCrudRepository.findById(taskId).map(mapper::toTask);
    }

    @Override
    public Task save(Task task) {
        // Si el ID es null, se considera una nueva tarea (crear)
        if (task.getTaskId() == null || task.getTaskId() == 0) {
            task.setTaskId(null); // dejar que Hibernate lo genere
        }
        Tareas tareaEntity = mapper.toTareas(task);
        Tareas saved = tareasCrudRepository.save(tareaEntity);
        return mapper.toTask(saved);
    }

    @Override
    public void delete(int idTareas) {
        tareasCrudRepository.deleteById(idTareas);
    }
}
