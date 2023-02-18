package rw.jazzyBruno.todo.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.jazzyBruno.todo.v1.models.Todo;
import rw.jazzyBruno.todo.v1.models.User;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    Optional<List<Todo>> findByUser(User user);
}
