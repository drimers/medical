package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private final PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping("/patient")
    public String index() {
       return "patient.html";
        // return "Greetings from Spring Boot Patients!";
    }
}
