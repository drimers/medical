package com.stefanpetkov.medical.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {


    @GetMapping("/doctor")
    public String index() {
        return "Greetings from Spring Boot Doctors!";
    }

}
