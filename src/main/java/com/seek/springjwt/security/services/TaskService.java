package com.seek.springjwt.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seek.springjwt.models.Task;
import com.seek.springjwt.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task addTask(Task task) {
        return repository.save(task);
    }

    public Optional<Task> getTaskById(String id) {
        return repository.findById(id);
    }

    public Task updateTask(String id, Task updatedTask) {
        Optional<Task> existingTask = repository.findById(id);
        if (existingTask.isPresent()) {
            Task task = existingTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            return repository.save(task);
        }
        return null;
    }

    public void deleteTask(String id) {
        repository.deleteById(id);
    }
}