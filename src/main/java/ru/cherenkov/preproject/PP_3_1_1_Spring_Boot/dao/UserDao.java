package ru.cherenkov.preproject.PP_3_1_1_Spring_Boot.dao;

import org.springframework.stereotype.Component;
import ru.cherenkov.preproject.PP_3_1_1_Spring_Boot.model.User;

import java.util.List;


@Component
public interface UserDao {

    public void saveUser(User user);

    public List<User> getAllUsers();

    public User getUserById(Long id);

    public void updateUser(User user);

    public void deleteUser(Long id);
}