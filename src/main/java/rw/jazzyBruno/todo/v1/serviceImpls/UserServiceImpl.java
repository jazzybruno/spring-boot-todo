package rw.jazzyBruno.todo.v1.serviceImpls;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import rw.jazzyBruno.todo.v1.models.User;
import rw.jazzyBruno.todo.v1.repositories.UserRepository;
import rw.jazzyBruno.todo.v1.services.UserService;
import rw.jazzyBruno.todo.v1.utils.DataValidation;
import rw.jazzyBruno.todo.v1.utils.PasswordUtility;

import java.sql.SQLException;
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

    public Optional<User> getUserByUsername(String username) throws Exception{
        try {
            Optional<User> user =   userRepository.findUserByUsername(username);
            return user;
        }catch (Exception e){
            throw new Exception("User with username " + username + " does not exist");
        }
    }

    public User addUser(User user) throws Exception {
        DataValidation dataValidation = new DataValidation();
        String userValidation = dataValidation.userValidation(user);
        if (userValidation.equals("isValid")) {
            Optional<User> optional = userRepository.findUserByEmail(user.getEmail());
            if (optional != null) {
                Optional optional1 = userRepository.findUserByUsername(user.getUsername());
                if (optional1 != null) {
                    // hashing the password
                    PasswordUtility passwordUtility = new PasswordUtility();
                    user.setPassword(passwordUtility.hashPassword(user.getPassword()));
                    userRepository.save(user);
                    return user;
                } else {
                    throw new Exception("The user with the given email does not exist");
                }
            } else {
                throw new Exception("The user with the given email already exists");
            }
        } else {
          throw new Exception(userValidation);
        }
    }


    public Optional<User> deleteUser(Long user_id) throws Exception{
        if (userRepository.existsById(user_id)){
             try {
                 Optional<User> user = userRepository.findById(user_id);
                 userRepository.delete(user.get());
                 return user;
             }catch (Exception e){
                 throw new Exception("Failed to delete the user with id: " + user_id);
             }
        }else{
            throw new Exception("The user with id: " + user_id + " does not exist");
        }
    }

    // updating the user in the database
    public void mapUser(User user , User user1){
        user.setUsername(user1.getUsername());
        user.setDob(user1.getDob());
        user.setEmail(user1.getEmail());
        user.setPassword(user1.getPassword());
        user.setGithubProfile(user1.getGithubProfile());
    }

    public User updateUser(@RequestBody User user , @PathVariable Long user_id) throws Exception{
        if(userRepository.existsById(user_id)){
            Optional<User> user1 = userRepository.findById(user_id);
            User user2 = user1.get();
            mapUser(user2 , user);
            return user2;
        }else{
            throw new Exception("The user with id: " + user_id + " does not exist");
        }
    }
}
