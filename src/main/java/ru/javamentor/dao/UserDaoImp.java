package ru.javamentor.dao;

import org.springframework.stereotype.Component;
import ru.javamentor.model.User;

import javax.persistence.*;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
