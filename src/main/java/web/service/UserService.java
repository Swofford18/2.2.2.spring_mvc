package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Transactional
    public void removeUser(long id) {
        userDAO.removeUser(id);
    }

    @Transactional
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
}
