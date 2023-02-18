package rw.jazzyBruno.todo.v1.utils;

import rw.jazzyBruno.todo.v1.models.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {
    Pattern email = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$");
    Pattern url = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$");


    //the validation for the user
    public String userValidation(User user){
        if(user.getUsername().length() < 3 || user.getUsername().length() > 10){
            return "The username must be from 3 to 10 characters";
        }else{
            Matcher matcher = email.matcher(user.getEmail());
            if(!matcher.find()){
                return "The email must be a valid email address";
            }else{
                Matcher matcher1 = url.matcher(user.getGithubProfile());
                if(!matcher1.find()){
                    return "The github link must be a valid url";
                }else{
                    return "isValid";
                }
            }
        }
    }
}
