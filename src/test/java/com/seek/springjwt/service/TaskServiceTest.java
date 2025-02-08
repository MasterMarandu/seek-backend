package com.seek.springjwt.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.seek.springjwt.models.Task;
import com.seek.springjwt.repository.TaskRepository;
import com.seek.springjwt.security.services.TaskService;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TaskServiceTest {
    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddTask() {
        Task task = new Task();
        task.setTitle("Test Task");
        when(repository.save(task)).thenReturn(task);
        assertEquals(task, service.addTask(task));
    }
}
