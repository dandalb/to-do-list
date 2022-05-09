package spring.todolist.model.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskRequestDto {
    private String description;
    private boolean isCompleted;
}
