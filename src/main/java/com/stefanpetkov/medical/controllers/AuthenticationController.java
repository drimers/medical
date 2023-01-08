package com.stefanpetkov.medical.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class AuthenticationController {


    @GetMapping("/login")
    public String login(Model model) {
        return "login/login.html";
    }

    @GetMapping("/register")
    public String register() {
        return "register/register.html";
    }

}
