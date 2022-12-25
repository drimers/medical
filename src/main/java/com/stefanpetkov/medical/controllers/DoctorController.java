package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DoctorController {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }



    @RequestMapping("/doctor")
    public String getPatient(Model model) {
        model.addAttribute("doctor", doctorRepository.findAll());
        return "doctor/list";
        // return "Greetings from Spring Boot Patients!";
    }


}
