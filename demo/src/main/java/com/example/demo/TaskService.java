package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> readAllTasks() {
        return taskRepository.findAll();
    }

    public Task readTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateRequiredTask(Long id, Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    public void deleteRequiredTask(Long id) {
        taskRepository.deleteById(id);
    }
}
