package spring.todolist.model.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserLoginDto {
    @Email
    private String email;

    @NotBlank(message = "Password can't be null or blank!")
    private String password;
}
