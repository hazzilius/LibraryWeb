package com.example.LibraryWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/denied")
    public String error() {
        return "errorHandling/denied";
    }

}
