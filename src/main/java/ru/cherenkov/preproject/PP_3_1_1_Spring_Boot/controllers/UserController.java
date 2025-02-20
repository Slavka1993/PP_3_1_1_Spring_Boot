package ru.cherenkov.preproject.PP_3_1_1_Spring_Boot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.cherenkov.preproject.PP_3_1_1_Spring_Boot.dao.UserDao;
import ru.cherenkov.preproject.PP_3_1_1_Spring_Boot.model.User;
import ru.cherenkov.preproject.PP_3_1_1_Spring_Boot.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String welcomePage() {
        return "welcome";
    }

    @GetMapping("users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/users/add")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "users/add";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping("/users/delete")
    public String update(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/users/read")
    public String readUserById(@RequestParam(name = "id", required = false) Long id, Model model) {
        if (id == null) {
            return "users/read";
        }
        User user = userService.getUserById(id);
        if (user == null) {
            model.addAttribute("message", "User not found " + id);
        } else {
            model.addAttribute("user", user);
        }
        return "users/read";
    }

    @GetMapping("users/edit")
    public String editUser(@RequestParam("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }


}
