package rw.jazzyBruno.todo.v1.services;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import rw.jazzyBruno.todo.v1.models.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getAllTodos() throws Exception;
    public List<Todo> getTodosByUser( Long user_id) throws Exception;
    public Todo getTodoById( Long todo_id) throws Exception;
    public Todo deleteTodo(Long todo_id) throws Exception;
    public Todo addTodo(Todo todo) throws Exception;
    public Todo updateTodo( Long todo_id , Todo todo) throws Exception;
}
