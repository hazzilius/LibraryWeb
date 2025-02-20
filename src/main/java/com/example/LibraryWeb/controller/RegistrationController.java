package com.example.LibraryWeb.controller;

import com.example.LibraryWeb.dto.UserDto;
import com.example.LibraryWeb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserDto userRegistrationDto() {
        return new UserDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

//    @PostMapping
//    public String registerUserAccount(@ModelAttribute("user")
//                                      UserDto registrationDto) {
//
//        try {
//            userService.createUser(registrationDto);
//        }catch(Exception e)
//        {
//            System.out.println(e);
//            return "redirect:/registration?email_invalid";
//        }
//        return "redirect:/registration?success";
//    }
}
