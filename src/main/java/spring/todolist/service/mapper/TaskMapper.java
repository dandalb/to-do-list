package spring.todolist.service.mapper;

import org.springframework.stereotype.Component;
import spring.todolist.model.Task;
import spring.todolist.model.dto.request.TaskRequestDto;
import spring.todolist.model.dto.response.TaskResponseDto;

@Component
public class TaskMapper {
    public Task fromDto(TaskRequestDto request) {
        return Task.builder().description(request.getDescription())
                .isCompleted(request.isCompleted()).build();
    }

    public TaskResponseDto toDto(Task task) {
        return TaskResponseDto.builder().description(task.getDescription())
                .isCompleted(task.isCompleted()).build();
    }
}
