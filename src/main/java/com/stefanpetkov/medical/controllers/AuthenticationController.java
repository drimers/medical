package com.stefanpetkov.medical.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class AuthenticationController {


    @RequestMapping("/login")
    public String login(Model model) {
        return "login/login.html";
    }

    @RequestMapping("/register")
    public String register() {
        return "register/register.html";
    }

}
