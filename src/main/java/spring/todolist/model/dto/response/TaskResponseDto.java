package spring.todolist.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskResponseDto {
    private String description;
    private boolean isCompleted;
}
