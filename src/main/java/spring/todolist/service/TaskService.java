package spring.todolist.service;

import spring.todolist.model.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    Task getById(UUID id);

    Task save(Task task);

    void delete(UUID id);

    List<Task> findAll();
}
