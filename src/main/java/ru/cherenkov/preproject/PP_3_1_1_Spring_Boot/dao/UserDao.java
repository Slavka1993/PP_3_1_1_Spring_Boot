package ru.cherenkov.preproject.PP_3_1_1_Spring_Boot.dao;

import org.springframework.stereotype.Component;
import ru.cherenkov.preproject.PP_3_1_1_Spring_Boot.model.User;

import java.util.List;



public interface UserDao {

    void saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
}