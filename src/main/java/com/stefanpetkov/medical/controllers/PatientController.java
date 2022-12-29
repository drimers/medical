package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.domain.CredentialsEntity;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class PatientController {

    private final PatientRepository patientRepository;
    private final CredentialsRepository credentialsRepository;


    @Autowired
    public PatientController(PatientRepository patientRepository, CredentialsRepository credentialsRepository) {
        this.patientRepository = patientRepository;
        this.credentialsRepository = credentialsRepository;
    }



    @RequestMapping("/patient")
    public String getPatient(Model model) {
        model.addAttribute("patient", patientRepository.findAll());
       // model.addAttribute("emailAccount", credentialsRepository.findByEmail("spp.bg@abv.bg"));

       return "patient/patient";
        // return "Greetings from Spring Boot Patients!";
    }
}
