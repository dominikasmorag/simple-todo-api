package com.dominikasmorag.todoapp.controller;

import com.dominikasmorag.todoapp.model.Task;
import com.dominikasmorag.todoapp.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAll();
    }


    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return taskService.getById(id);
    }

    @GetMapping("/not-done")
    public List<Task> getNotDone() {
        return taskService.getByDoneFalse();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Task add(@RequestBody Task task) {
        return taskService.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }

}
