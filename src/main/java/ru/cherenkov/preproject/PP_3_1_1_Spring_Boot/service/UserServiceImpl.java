package ru.cherenkov.preproject.PP_3_1_1_Spring_Boot.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cherenkov.preproject.PP_3_1_1_Spring_Boot.dao.UserDao;
import ru.cherenkov.preproject.PP_3_1_1_Spring_Boot.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
