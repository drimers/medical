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
public class DoctorController {

    private final DoctorRepository doctorRepository;
    private final CredentialsRepository credentialsRepository;
    private final PatientRepository patientRepository;

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository, CredentialsRepository credentialsRepository, PatientRepository patientRepository, AppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.credentialsRepository = credentialsRepository;
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }



    @RequestMapping("/doctor")
    public String getPatient(Model model) {
        model.addAttribute("patient", patientRepository.findAll());
        model.addAttribute("appointment", appointmentRepository.findByAppointmentId(1L));
        return "doctor/doctor";
        // return "Greetings from Spring Boot Patients!";
    }


}
