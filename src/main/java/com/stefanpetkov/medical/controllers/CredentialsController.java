package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.commands.PatientCommand;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CredentialsController {

    private final CredentialsRepository credentialsRepository;


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        //model.addAttribute("credentials", new UserCredentials());
        return "login";
    }


    // Form registration
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("patient", new PatientCommand());
        return "register";
    }


}

