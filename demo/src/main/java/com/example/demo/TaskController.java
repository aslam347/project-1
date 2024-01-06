package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> readAllTasks() {
        return taskService.readAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> readTaskById(@PathVariable Long id) {
        Task task = taskService.readTaskById(id);
        return ResponseEntity.of(Optional.ofNullable(task));
    }

    @PostMapping
    public ResponseEntity<Task> createNewTask(@RequestBody Task task) {
        Task createdTask = taskService.createNewTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateRequiredTask(@PathVariable Long id, @RequestBody Task task) {
        Task updatedTask = taskService.updateRequiredTask(id, task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequiredTask(@PathVariable Long id) {
        taskService.deleteRequiredTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
