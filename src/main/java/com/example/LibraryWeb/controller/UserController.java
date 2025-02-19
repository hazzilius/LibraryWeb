package com.example.LibraryWeb.controller;

import com.example.LibraryWeb.model.User;
import com.example.LibraryWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user){
        if (userService.existsByEmail(user.getEmail())){
            return "redirect:/register?error";
        }
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String viewProfile(Model model){
        User user = new User();
        user.setName("Иван Иванович");
        model.addAttribute("user", user);
        return "profile";
    }

}
