package com.seek.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seek.springjwt.models.Task;

public interface TaskRepository extends JpaRepository<Task, String> {}
