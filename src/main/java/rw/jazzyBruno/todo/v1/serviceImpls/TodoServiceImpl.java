package rw.jazzyBruno.todo.v1.serviceImpls;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import rw.jazzyBruno.todo.v1.models.Todo;
import rw.jazzyBruno.todo.v1.models.User;
import rw.jazzyBruno.todo.v1.repositories.TodoRepository;
import rw.jazzyBruno.todo.v1.repositories.UserRepository;
import rw.jazzyBruno.todo.v1.utils.DataValidation;

import java.util.List;
import java.util.Optional;

@Component
public class TodoServiceImpl {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoServiceImpl(TodoRepository todoRepository,
                           UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    public List<Todo> getAllTodos() throws Exception {
        try {
            return todoRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Failed to fetching all users");
        }
    }
    ;

    public List<Todo> getTodosByUser(Long user_id) throws Exception {
        if (userRepository.existsById(user_id)) {
            try {
                User user = (userRepository.findById(user_id)).get();
                List<Todo> todos = (todoRepository.findByUser(user)).get();
                return todos;
            } catch (Exception e) {
                throw new Exception("Failed to fetch todos for user with id: " + user_id);
            }
        } else {
            throw new Exception("The user with id: " + user_id + " does not exist");
        }
    }

    ;

    public Todo getTodoById(@PathVariable Long todo_id) throws Exception {
        if (todoRepository.existsById(todo_id)) {
            try {
                Todo todo = (todoRepository.findById(todo_id)).get();
                return todo;
            } catch (Exception e) {
                throw new Exception("Failed to fetch the todo with id: " + todo_id);
            }
        } else {
            throw new Exception("The tod with id: " + todo_id + " does not exist");
        }
    }

    public Todo addTodo(Todo todo) throws Exception{
        DataValidation validation = new DataValidation();
        String validate = validation.todoValidation(todo);
        if(validate.equals("isValid")){
            if(userRepository.existsById(todo.getUser().getId())){
            Todo todo1 = (todoRepository.findByContent(todo.getContent())).get();
            if(todo1 == null){
                try {
                    todoRepository.save(todo);
                    return todo;
                }catch (Exception e){
                    throw new Exception("Failed to add a todo");
                }
            }else{
                throw new Exception("This todo already exists");
            }}else{
                throw new Exception("The user provided does not exist");
            }
        }else{
            throw new Exception(validate);
        }

    };

    public void mapTodo(Todo todo , Todo todoNew){
        todo.setContent(todoNew.getContent());
        todo.setPhoto(todoNew.getPhoto());
        todo.setTime_finish(todoNew.getTime_finish());
        todo.setDone(todoNew.isDone());
    }

    @Transactional
    public Todo updateTodo( Long todo_id , Todo todo) throws Exception{
        DataValidation dataValidation = new DataValidation();
       String validate =  dataValidation.todoValidation(todo);
       if(validate.equals("isValid")){
           if(todoRepository.existsById(todo_id)){
               Todo todo1 = (todoRepository.findById(todo_id)).get();
               try {
                   mapTodo(todo1 , todo);
                   return todo1;
               }catch (Exception e){
                   throw new Exception("Failed to delete the todo with id: " + todo_id);
               }
           }else {
               throw new Exception("The todo with id: " + todo_id + " does not exist");
           }
       }else{
           throw new Exception(validate);
       }
    }

    public Todo deleteTodo(Long todo_id) throws Exception {
        if (todoRepository.existsById(todo_id)) {
            Todo todo = (todoRepository.findById(todo_id)).get();
            try {
                todoRepository.deleteById(todo_id);
                return todo;
            } catch (Exception e) {
                throw new Exception("Failed to delete the todo with id: " + todo_id);
            }
        } else {
            throw new Exception("The tod with id: " + todo_id + " does not exist");
        }
    }
}
