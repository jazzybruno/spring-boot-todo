package rw.jazzyBruno.todo.v1.serviceImpls;

import org.springframework.stereotype.Component;
import rw.jazzyBruno.todo.v1.models.User;
import rw.jazzyBruno.todo.v1.repositories.UserRepository;
import rw.jazzyBruno.todo.v1.services.UserService;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private  final  UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<User> getAllUsers() throws Exception {
        try {
            List<User> users = userRepository.findAll();
            return users;
        }catch (Exception e){
            throw new Exception("Failed to fetch all users");
        }
    }
}
