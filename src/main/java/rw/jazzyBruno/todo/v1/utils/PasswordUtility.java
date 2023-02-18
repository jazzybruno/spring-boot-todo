package rw.jazzyBruno.todo.v1.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtility {
    //the hashing method of passwords
    public String hashPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    //the verification method
    public boolean checkValidity(String password , String hashed){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password , hashed);
    }
}
