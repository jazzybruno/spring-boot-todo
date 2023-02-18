package rw.jazzyBruno.todo.v1.serviceImpls;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;
import rw.jazzyBruno.todo.v1.models.Todo;
import rw.jazzyBruno.todo.v1.models.User;
import rw.jazzyBruno.todo.v1.repositories.TodoRepository;
import rw.jazzyBruno.todo.v1.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Component
public class TodoServiceImpl {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoServiceImpl(TodoRepository todoRepository,
                           UserRepository userRepository){
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    public List<Todo> getAllTodos() throws Exception{
        try {
            return todoRepository.findAll();
        }catch (Exception e){
            throw new Exception("Failed to fetching all users");
        }
    };

    public List<Todo> getTodosByUser( Long user_id) throws Exception{
       if (userRepository.existsById(user_id)){
           try {
               User user  = (userRepository.findById(user_id)).get();
               List<Todo> todos = (todoRepository.findByUser(user)).get();
               return todos;
           }catch (Exception e){
               throw new Exception("Failed to fetch todos for user with id: " + user_id);
           }
       }else {
           throw new Exception("The user with id: " + user_id + " does not exist");
       }
    };
}
