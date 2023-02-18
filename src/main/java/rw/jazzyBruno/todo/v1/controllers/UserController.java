package rw.jazzyBruno.todo.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.jazzyBruno.todo.v1.models.User;
import rw.jazzyBruno.todo.v1.serviceImpls.UserServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUsers() throws Exception{
       return userService.getAllUsers();
    }

    @GetMapping("/{user_id}")
    public Optional<User> getUserById(@PathVariable Long user_id) throws Exception{
         return userService.getUserById(user_id);
    }
}
