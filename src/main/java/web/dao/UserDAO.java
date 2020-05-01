package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    void add(User user);
    List<User> listUsers();
    void removeUser(long id);
    User getUserById(long id);
    void updateUser(User user);
    User getUserByUsername(String s);
}
