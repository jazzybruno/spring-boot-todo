package rw.jazzyBruno.todo.v1.serviceImpls;

import org.springframework.stereotype.Component;
import rw.jazzyBruno.todo.v1.models.User;
import rw.jazzyBruno.todo.v1.repositories.UserRepository;
import rw.jazzyBruno.todo.v1.services.UserService;

import java.util.List;
import java.util.Optional;

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
            e.printStackTrace();
            throw new Exception("Failed to fetch all users");
        }
    }

    @Override
    public Optional<User> getUserById(Long user_id) throws Exception{
        if(userRepository.existsById(user_id)){
            try {
                Optional<User> user = userRepository.findById(user_id);
                return user;
            }catch (Exception e){
                throw new Exception("Failed to fetch the user with id " + user_id);
            }
        }else{
            throw new Exception("The user with id " + user_id + " does not exist");
        }
    }
}
