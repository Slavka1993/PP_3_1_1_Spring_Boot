package ru.cherenkov.preproject.PP_3_1_1_Spring_Boot.service;

import ru.cherenkov.preproject.PP_3_1_1_Spring_Boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);
}
