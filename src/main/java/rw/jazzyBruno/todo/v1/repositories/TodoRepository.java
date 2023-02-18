package rw.jazzyBruno.todo.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.jazzyBruno.todo.v1.models.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
