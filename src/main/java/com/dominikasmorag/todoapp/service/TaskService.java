package com.dominikasmorag.todoapp.service;

import com.dominikasmorag.todoapp.model.Task;
import com.dominikasmorag.todoapp.repository.TaskRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostConstruct
    public void init() {
        Task task = new Task();
        task.setName("test1");
        task.setDone(true);

        Task task2 = new Task();
        task2.setName("test2");
        task2.setDone(false);

        taskRepository.save(task);
        taskRepository.save(task2);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND , "Task not found"));
    }

    public List<Task> getByDoneFalse() {
        return taskRepository.findByDoneFalse();
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

}
