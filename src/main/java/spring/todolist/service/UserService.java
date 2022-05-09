package spring.todolist.service;

import spring.todolist.model.User;

public interface UserService {
    User findByEmail(String email);

    User save(User user);

    Boolean existsByEmail(String email);
}
