package rw.jazzyBruno.todo.v1.utils;

import rw.jazzyBruno.todo.v1.models.User;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {
    Pattern email = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$");
    Pattern url = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$");

    Pattern password = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

     // the url validation function
     public static boolean isValidUrl(String urlString) {
         try {
             new URL(urlString);
             return true;
         } catch ( MalformedURLException e) {
             return false;
         }
     }

     //the password validation method
     public static boolean isValidPassword(String password) {
         String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
         return password.matches(passwordPattern);
     }

    //the validation for the user
    public String userValidation(User user){
        if(user.getUsername().length() < 3 || user.getUsername().length() > 10){
            return "The username must be from 3 to 10 characters";
        }else{
            Matcher matcher = email.matcher(user.getEmail());
            if(!matcher.find()){
                return "The email must be a valid email address";
            }else{
                boolean isUrl = isValidUrl(user.getGithubProfile());
                if(!isUrl){
                    return "The github link must be a valid url";
                }else{
                    boolean isPassword = isValidPassword(user.getPassword());
                    if(!isPassword){
                      return "The password must have a lower and upper case letter, numbers and a special letter!!";
                    }else{
                        return "isValid";
                    }
                }
            }
        }
    }
}
