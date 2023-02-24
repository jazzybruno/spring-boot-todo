package rw.jazzyBruno.todo.v1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticateDTO {
    private String email;
    private String password;
}
