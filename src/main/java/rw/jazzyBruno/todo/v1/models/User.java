package rw.jazzyBruno.todo.v1.models;

import java.time.LocalDate;

public class User {
    private Long id;
    private String username;
    private String email;
    private String githubProfile;
    private LocalDate dob;
    private String password;

    public User(){

    }
    public User(String username, String email, String githubProfile, LocalDate dob, String password) {
        this.username = username;
        this.email = email;
        this.githubProfile = githubProfile;
        this.dob = dob;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGithubProfile() {
        return githubProfile;
    }

    public void setGithubProfile(String githubProfile) {
        this.githubProfile = githubProfile;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
