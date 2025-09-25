package com.cg.SpringSecurityDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cg.SpringSecurityDemo.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "users";
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute com.cg.SpringSecurityDemo.entity.User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
