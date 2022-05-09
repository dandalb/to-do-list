package spring.todolist.service;

import org.springframework.stereotype.Service;
import spring.todolist.model.Task;
import spring.todolist.repository.TaskRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task getById(UUID id) {
        return taskRepository.getById(id);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void delete(UUID id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
}
