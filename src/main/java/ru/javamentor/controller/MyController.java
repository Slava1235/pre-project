package ru.javamentor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.model.User;
import ru.javamentor.service.UserService;

@Controller
public class MyController {

    private UserService userService;

    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("allUser", userService.getAllUsers());
        return "allUsers";
    }

    @RequestMapping(value = "/addNewUser")
    public String addNewUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "user-info";
    }

    @RequestMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/updateInfo/{id}")
    public String updateInfo(@PathVariable("id") Long id, ModelMap model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}
