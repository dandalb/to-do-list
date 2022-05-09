package spring.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.todolist.model.Task;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
}
