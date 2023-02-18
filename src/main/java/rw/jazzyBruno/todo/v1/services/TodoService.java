package rw.jazzyBruno.todo.v1.services;

import org.springframework.web.bind.annotation.PathVariable;
import rw.jazzyBruno.todo.v1.models.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getAllTodos() throws Exception;
    public List<Todo> getTodosByUser( Long user_id) throws Exception;
}
