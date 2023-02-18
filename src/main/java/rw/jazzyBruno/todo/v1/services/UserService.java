package rw.jazzyBruno.todo.v1.services;

import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import rw.jazzyBruno.todo.v1.models.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getAllUsers() throws Exception;
    public Optional<User> getUserById(Long user_id) throws Exception;
    public Optional<User> getUserByUsername(String username) throws Exception;
    public User addUser(User user) throws Exception;
    public Optional<User> deleteUser(Long user_id) throws Exception;
    public User updateUser(@RequestBody User user , @PathVariable Long user_id) throws Exception;
}
