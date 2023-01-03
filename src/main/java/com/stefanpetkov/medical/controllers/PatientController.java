package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@RequiredArgsConstructor
@Controller
public class PatientController {

    private final PatientRepository patientRepository;
    private final CredentialsRepository credentialsRepository;


    @RequestMapping("/patient")
    public String getPatient(Model model) {
        model.addAttribute("patient", patientRepository.findAll());
       return "patient/patient";
    }
}
