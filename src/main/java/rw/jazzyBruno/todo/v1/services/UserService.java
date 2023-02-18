package rw.jazzyBruno.todo.v1.services;

import rw.jazzyBruno.todo.v1.models.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers() throws Exception;
}
