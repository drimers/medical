package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.repositories.PatientRepository;
import com.stefanpetkov.medical.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }



    @RequestMapping("/patient")
    public String getPatient(Model model) {
        model.addAttribute("patient", patientRepository.findAll());
       return "patient";
        // return "Greetings from Spring Boot Patients!";
    }
}
