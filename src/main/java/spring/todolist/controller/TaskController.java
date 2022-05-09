package spring.todolist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.todolist.model.Task;
import spring.todolist.model.dto.request.TaskRequestDto;
import spring.todolist.model.dto.response.TaskResponseDto;
import spring.todolist.service.TaskService;
import spring.todolist.service.mapper.TaskMapper;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> add(@RequestBody TaskRequestDto taskRequestDto) {
        Task task = taskService.save(taskMapper.fromDto(taskRequestDto));
        return new ResponseEntity<>(taskMapper.toDto(task), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> get(@PathVariable UUID id) {
        return new ResponseEntity<>(taskMapper.toDto(taskService.getById(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAll() {
        return new ResponseEntity<>(taskService.findAll()
                .stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> update(
            @PathVariable UUID id,
            @RequestBody TaskRequestDto taskRequestDto) {
        Task task = taskMapper.fromDto(taskRequestDto);
        task.setId(id);
        taskService.save(task);
        return new ResponseEntity<>(taskMapper.toDto(task), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        taskService.delete(id);
    }
}
