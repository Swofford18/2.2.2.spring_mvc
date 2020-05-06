package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserService implements UserServiceInt {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void add(User user) {
        userDAO.add(user);
    }

    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    public void removeUser(long id) {
        userDAO.removeUser(id);
    }

    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDAO.getUserByUsername(s);
    }
}
