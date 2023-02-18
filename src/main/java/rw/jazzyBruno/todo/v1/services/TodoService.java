package rw.jazzyBruno.todo.v1.services;

import rw.jazzyBruno.todo.v1.models.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getAllTodos() throws Exception;
}
