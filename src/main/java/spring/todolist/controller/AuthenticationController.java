package spring.todolist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.todolist.model.dto.request.UserLoginDto;
import spring.todolist.model.dto.request.UserRegistrationDto;
import spring.todolist.model.dto.response.TokenResponseDto;
import spring.todolist.service.AuthenticationService;
import spring.todolist.service.UserService;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(UserService userService,
                                    AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid UserRegistrationDto userRequestDto) {
        if (userService.existsByEmail(userRequestDto.getEmail())) {
            return new ResponseEntity<>("This email already exists", HttpStatus.BAD_REQUEST);
        }
        authenticationService.register(userRequestDto.getEmail(), userRequestDto.getPassword());
        return new ResponseEntity<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UserLoginDto userLoginDto) {
        String token = authenticationService.login(userLoginDto.getEmail(), userLoginDto.getPassword());
        return new ResponseEntity<>(Map.of("token", new TokenResponseDto(token)), HttpStatus.OK);
    }
}
