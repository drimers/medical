package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.repositories.AppointmentRepository;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientController {

    private final PatientRepository patientRepository;
    private final CredentialsRepository credentialsRepository;
    private final DoctorRepository doctorRepository;

    private final AppointmentRepository appointmentRepository;


    @Autowired
    public PatientController(PatientRepository patientRepository, CredentialsRepository credentialsRepository,
                             DoctorRepository doctorRepository, AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.credentialsRepository = credentialsRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
    }



    @RequestMapping("/patient")
    public String getDoctor(Model model) {
        model.addAttribute("doctor", doctorRepository.findAll());
        model.addAttribute("appointment", appointmentRepository.findByAppointmentId(1L));

      //  model.addAttribute("appointment", appointmentRepository.findAllByPatientId(9L));
       // model.addAttribute("emailAccount", credentialsRepository.findByEmail("spp.bg@abv.bg"));

       return "patient/patient";
        // return "Greetings from Spring Boot Patients!";
    }







 }
