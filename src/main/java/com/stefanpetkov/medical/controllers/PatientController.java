package com.stefanpetkov.medical.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @GetMapping("/patient")
    public String index() {
        return "Greetings from Spring Boot Patients!";
    }
}
