package com.tareas.gestor.domain.service;

import com.tareas.gestor.domain.Task;
import com.tareas.gestor.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.getAll();
    }

    public Optional<Task> getTask(int taskId) {
        return taskRepository.getTask(taskId);
    }

    public Optional<List<Task>> getByCategory(int categoryId) {
        return taskRepository.getByCategory(categoryId);
    }

    public Optional<List<Task>> getByPriority(char priority) {
        return taskRepository.getByPriority(priority);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public boolean delete(int taskId) {
        return getTask(taskId).map(task -> {
            taskRepository.delete(taskId);
            return true;
        }).orElse(false);
    }
}

