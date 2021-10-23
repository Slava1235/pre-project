package ru.javamentor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.dao.UserDaoImp;
import ru.javamentor.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDaoImp userDaoImp;

    @Autowired
    public UserServiceImp(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDaoImp.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDaoImp.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return userDaoImp.getUser(id);
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        userDaoImp.removeUser(id);
    }
}
