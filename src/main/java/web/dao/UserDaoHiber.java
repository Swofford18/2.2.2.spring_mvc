package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoHiber implements UserDAO {

    private SessionFactory sessionFactory;

    public UserDaoHiber(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void removeUser(long id) {

        User user = sessionFactory.getCurrentSession().load(User.class, id);

        if(user != null){
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public User getUserById(long id) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User getUserByUsername(String s) {
        User user = (User) sessionFactory.getCurrentSession().createQuery("from User where username='" + s + "'").uniqueResult();
        return user;
    }
}
