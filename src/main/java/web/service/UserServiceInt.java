package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;

import java.util.List;

public interface UserServiceInt extends UserDetailsService {

    void add(User user);
    List<User> listUsers();
    void removeUser(long id);
    User getUserById(long id);
    void updateUser(User user);

}
