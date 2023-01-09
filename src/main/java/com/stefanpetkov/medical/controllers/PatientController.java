package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.domain.*;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import com.stefanpetkov.medical.services.AppointmentService;
import com.stefanpetkov.medical.services.DoctorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@RequiredArgsConstructor
@Controller
public class PatientController {


    private final AppointmentService appointmentService;
    private final DoctorService doctorService;
    private final CredentialsRepository credentialsRepository;

    private final PatientRepository patientRepository;


    @RequestMapping("/patient")
    public String getDoctor(Model model) {
        log.info("PatientController::getDoctor()");
        model.addAttribute("doctors", appointmentService.findAllDoctorsByPatientId(2L));
        model.addAttribute("appointments", appointmentService.findAll());
       // model.addAttribute("appointments", appointmentService.findAllDoctorsByPatientId(1L));
        return "patient/patient";
    }


    // Form registration

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String register(@ModelAttribute("doctors") DoctorEntity doctor, @ModelAttribute("appointment") AppointmentEntity appointment, Model model) {
        System.out.println("get appointment:::" + appointment.getDateTimeOfTheAppointment());
        // doctorService.save(doctor);
        model.addAttribute("appointment", appointment);
        appointmentService.save(appointment);
        return "/patient/patient";
    }

//    @RequestMapping("/patient/{id}")
//    public String getDoctor(@PathVariable String id, Model model) {
//        model.addAttribute("doctor", doctorRepository.findAll());
//        model.addAttribute("appointment", appointmentRepository.findByAppointmentId(new Long(id)));
//
//        //  model.addAttribute("appointment", appointmentRepository.findAllByPatientId(9L));
//        // model.addAttribute("emailAccount", credentialsRepository.findByEmail("spp.bg@abv.bg"));
//
//        return "patient/patient";
//        // return "Greetings from Spring Boot Patients!";
//    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        PatientEntity patient = new PatientEntity();
        CredentialsEntity credentials = new CredentialsEntity();
//        List<String> role = new ArrayList<>();
//        role.add("Patient");
//        role.add("Doctor");
//        model.addAttribute("roles", role);
        model.addAttribute("patient", patient);
        model.addAttribute("credential", credentials);
        return "register";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String register(@ModelAttribute("patient") PatientEntity patient, @ModelAttribute("doctor") DoctorEntity doctor, @ModelAttribute("credential") CredentialsEntity credential, Model model) {
        System.out.println("get UserName:::" + patient.getFirstName());

//        model.addAttribute("patient", patient);
//        model.addAttribute("credential", credential);


        credential.setRole(Role.PATIENT);
        patient.setCredentials(credential);
        credential.setBaseUser(patient);
        patientRepository.save(patient);
        credentialsRepository.save(credential);
        log.info("Patient registration :: save()");
        return "display_form";

    }

}



