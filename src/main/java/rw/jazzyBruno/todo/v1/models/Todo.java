package rw.jazzyBruno.todo.v1.models;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "todos" , uniqueConstraints = {@UniqueConstraint(columnNames = {("content")})})
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long todo_id;
    @Column(name = "content")
    @NotNull
    @ApiModelProperty( name = "The content of the todo")
    private String content;

    @ApiModelProperty(name = "The image of the task if neccessary")
    private String photo;
    @NotNull
    @ApiModelProperty(name = "The time the date was added")
    private LocalDate added_time;
    @NotNull
    @ApiModelProperty(name = "the time it will be finished")
    private LocalDate time_finish;
    @NotNull
    @ApiModelProperty(name = "The status of the todo if it is done or not")
    private boolean isDone;
    @ManyToOne
    @ApiModelProperty(name = "The user who has created the task")
    @JoinColumn(name = "user_id")
    private User user;

    public Todo(){

    }

    public Todo(String content, String photo, LocalDate added_time, LocalDate time_finish, boolean isDone, User user) {
        this.content = content;
        this.photo = photo;
        this.added_time = added_time;
        this.time_finish = time_finish;
        this.isDone = isDone;
        this.user = user;
    }

    public Long getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(Long todo_id) {
        this.todo_id = todo_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public LocalDate getAdded_time() {
        return added_time;
    }

    public void setAdded_time(LocalDate added_time) {
        this.added_time = added_time;
    }

    public LocalDate getTime_finish() {
        return time_finish;
    }

    public void setTime_finish(LocalDate time_finish) {
        this.time_finish = time_finish;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
