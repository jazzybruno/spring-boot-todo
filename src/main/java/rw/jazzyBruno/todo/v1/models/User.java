package rw.jazzyBruno.todo.v1.models;

import com.sun.istack.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import rw.jazzyBruno.todo.v1.enums.gender;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users" , uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The user id")
    private Long id;
    @ApiModelProperty(name = "The username for the user")
    @NotNull
    private String username;
    @ApiModelProperty(name = "The email for the user ")
    @NotNull
    @Column(name = "email")
    private String email;
    @ApiModelProperty(name = "The gender of the user")
    @NotNull
    @Enumerated(EnumType.STRING)
    private gender gender;
    @ApiModelProperty(name = "The github profile to get the profile picture")
    @NotNull
    private String githubProfile;
    @ApiModelProperty(name = "The date of birth of the user")
    @NotNull
    private LocalDate dob;
    @ApiModelProperty(name = "The password of the user")
    @NotNull
    private String password;

    public User(){

    }
    public User(String username, String email, String githubProfile, gender gender , LocalDate dob, String password) {
        this.username = username;
        this.email = email;
        this.githubProfile = githubProfile;
        this.dob = dob;
        this.password = password;
        this.gender = gender;
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

    public gender getGender() {
        return gender;
    }

    public void setGender(gender gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
