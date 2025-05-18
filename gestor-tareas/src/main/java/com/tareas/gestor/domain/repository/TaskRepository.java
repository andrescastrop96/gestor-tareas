package com.tareas.gestor.domain.repository;

import com.tareas.gestor.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> getAll();
    Optional<List<Task>> getByCategory(int taskId);
    Optional<List<Task>> getByPriority(char priority);
    Optional<Task> getTask(int taskId);
    Task save(Task task);
    void delete(int taskId);
}
