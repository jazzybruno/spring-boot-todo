package rw.jazzyBruno.todo.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rw.jazzyBruno.todo.v1.models.User;
import rw.jazzyBruno.todo.v1.repositories.UserRepository;
import rw.jazzyBruno.todo.v1.serviceImpls.UserServiceImpl;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private final UserServiceImpl userService;
    private final UserRepository userRepository;

    public UserController(UserServiceImpl userService,
                          UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @GetMapping
    public List<User> getAllUsers() throws Exception{
       return userService.getAllUsers();
    }

    @GetMapping("/user/{user_id}")
    public Optional<User> getUserById(@PathVariable Long user_id) throws Exception{
         return userService.getUserById(user_id);
    }

    @GetMapping("/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) throws Exception{
        return userService.getUserByUsername(username);
    }

    @PostMapping
    public User addUser(@RequestBody User user) throws Exception{
        return userService.addUser(user);
    }

    @DeleteMapping("/{user_id}")
    public Optional<User> deleteUser(@PathVariable Long user_id) throws Exception{
        return userService.deleteUser(user_id);
    }

    @PutMapping("/{user_id}")
    public User updateUser(@RequestBody User user , @PathVariable Long user_id) throws Exception{
        return userService.updateUser(user , user_id);
    }
}
