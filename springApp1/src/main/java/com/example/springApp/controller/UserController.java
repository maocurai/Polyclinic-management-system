package com.example.springApp.controller;

import com.example.springApp.domain.Role;
import com.example.springApp.domain.User;
import com.example.springApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("userToEdit", user)
                .addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam("role") String role,
            @RequestParam("userId") User user
    ) {
        user.setUsername(username);
        user.setRole(Role.valueOf(role));
        userService.save(user);
        return "redirect:/user";
    }
}