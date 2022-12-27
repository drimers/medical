package com.stefanpetkov.medical.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {


    @RequestMapping({"","/", "/home"})
    public String home() {
     //   model.addAttribute("doctor", doctorRepository.findAll());
        return "home/home";
        // return "Greetings from Spring Boot Patients!";
    }

}
