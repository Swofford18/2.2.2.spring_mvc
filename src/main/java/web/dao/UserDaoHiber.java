package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoHiber implements UserDAO {

    private EntityManagerFactory entityManagerFactory;

    public UserDaoHiber(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void add(User user) {

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public List<User> listUsers() {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.createQuery("from User").getResultList();
    }

    @Override
    public void removeUser(long id) {

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.remove(user);
        em.getTransaction().commit();
    }

    @Override
    public User getUserById(long id) {
        return entityManagerFactory.createEntityManager().find(User.class, id);
    }

    @Override
    public void updateUser(User user) {

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        User existingUser = em.find(User.class, user.getId());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setRoles(user.getRoles());
        em.getTransaction().commit();
    }

    @Override
    public User getUserByUsername(String s) {
        return (User) entityManagerFactory.createEntityManager()
                .createQuery("from User where username = ?1")
                .setParameter(1, s)
                .getSingleResult();
    }
}
