package rw.jazzyBruno.todo.v1.controllers;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.jazzyBruno.todo.v1.models.Todo;
import rw.jazzyBruno.todo.v1.serviceImpls.TodoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    @Autowired
    private final TodoServiceImpl todoService;

    public TodoController(TodoServiceImpl todoService){
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() throws Exception{
        return todoService.getAllTodos();
    }

}
