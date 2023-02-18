package rw.jazzyBruno.todo.v1.serviceImpls;

import org.springframework.stereotype.Component;
import rw.jazzyBruno.todo.v1.models.Todo;
import rw.jazzyBruno.todo.v1.repositories.TodoRepository;

import java.util.List;

@Component
public class TodoServiceImpl {

    private final TodoRepository todoRepository;
    public TodoServiceImpl(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() throws Exception{
        try {
            return todoRepository.findAll();
        }catch (Exception e){
            throw new Exception("Failed to fetching all users");
        }
    };
}
