package com.tareas.gestor.web.controller;

import com.tareas.gestor.domain.Task;
import com.tareas.gestor.domain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") int taskId) {
        return taskService.getTask(taskId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Task>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return taskService.getByCategory(categoryId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Task>> getByPriority(@PathVariable("priority") String priority) {
        return taskService.getByPriority(priority.charAt(0))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Task> save(@RequestBody Task task) {
        System.out.println("TaskId recibido en el controller: " + task.getTaskId());
        Task savedTask = taskService.save(task);
        return new ResponseEntity<>(taskService.save(savedTask), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int taskId) {
        boolean deleted = taskService.delete(taskId);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
