package com.stefanpetkov.medical.controllers;

import antlr.ASTNULLType;
import com.stefanpetkov.medical.commands.PatientCommand;
import com.stefanpetkov.medical.repositories.PatientRepository;
import com.stefanpetkov.medical.services.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {


    @RequestMapping({"","/", "/home"})
    public String home() {
     //   model.addAttribute("doctor", doctorRepository.findAll());
        return "home/home";
        // return "Greetings from Spring Boot Patients!";
    }

    @RequestMapping({ "/contact"})
    public String contact() {
        //   model.addAttribute("doctor", doctorRepository.findAll());
        return "contact/contact";
        // return "Greetings from Spring Boot Patients!";
    }




}
