package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.UserDataHandler;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
@EnableTransactionManagement(proxyTargetClass = true)
public class UserService implements UserDetailsService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

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

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDAO.getUserByUsername(s);
    }
}
