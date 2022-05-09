package spring.todolist.service;

public interface AuthenticationService {
    void register(String email, String password);

    String login(String email, String password);
}
