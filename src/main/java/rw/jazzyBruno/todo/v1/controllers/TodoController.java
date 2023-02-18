package rw.jazzyBruno.todo.v1.controllers;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/user/{user_id}")
    public List<Todo> getTodosByUser(@PathVariable Long user_id) throws Exception{
         return todoService.getTodosByUser(user_id);
    }
    @GetMapping("/id/{todo_id}")
    public Todo getTodoById(@PathVariable Long todo_id) throws Exception{
    return todoService.getTodoById(todo_id);
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) throws Exception{
        return todoService.addTodo(todo);
    }

    @PutMapping("/{todo_id}")
    public Todo updateTodo( @PathVariable Long todo_id ,  @RequestBody Todo todo) throws Exception{
        return todoService.updateTodo(todo_id ,  todo);
    }

    @DeleteMapping("/{todo_id}")
    public Todo deleteTodo(@PathVariable Long todo_id) throws Exception{
        return todoService.deleteTodo(todo_id);
    }
}
