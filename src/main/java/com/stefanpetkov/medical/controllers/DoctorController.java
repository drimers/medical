package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoctorController {

    private final DoctorRepository doctorRepository;
    private final CredentialsRepository credentialsRepository;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository, CredentialsRepository credentialsRepository) {
        this.doctorRepository = doctorRepository;
        this.credentialsRepository = credentialsRepository;
    }



    @RequestMapping("/doctor")
    public String getPatient(Model model) {
        model.addAttribute("doctor", doctorRepository.findAll());
        return "doctor/doctor";
        // return "Greetings from Spring Boot Patients!";
    }


}
