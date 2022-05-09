package spring.todolist.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.todolist.model.User;
import spring.todolist.service.UserService;
import org.springframework.security.core.userdetails.User.UserBuilder;

import java.util.Set;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);

        UserBuilder builder;
        if (user != null) {
            builder = withUsername(email);
            builder.password(user.getPassword());
            builder.authorities(new SimpleGrantedAuthority("ROlE_USER"));
            return builder.build();
        }
        throw new UsernameNotFoundException("User not found.");
    }
}
