package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.domain.CredentialsEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.repositories.AppointmentRepository;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import com.stefanpetkov.medical.services.CredentialsService;
import com.stefanpetkov.medical.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    private final PatientRepository patientRepository;
    private final CredentialsRepository credentialsRepository;
    private final DoctorRepository doctorRepository;

    private final AppointmentRepository appointmentRepository;

    private final PatientService patientService;
    private final CredentialsService credentialsService;


    @Autowired
    public PatientController(PatientRepository patientRepository, CredentialsRepository credentialsRepository,
                             DoctorRepository doctorRepository, AppointmentRepository appointmentRepository, PatientService patientService, CredentialsService credentialsService) {
        this.patientRepository = patientRepository;
        this.credentialsRepository = credentialsRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.patientService = patientService;
        this.credentialsService = credentialsService;
    }



    @RequestMapping("/patient")
    public String getDoctor( Model model) {
        model.addAttribute("doctor", doctorRepository.findAll());
        model.addAttribute("appointment", appointmentRepository.findByAppointmentId(1L));

      //  model.addAttribute("appointment", appointmentRepository.findAllByPatientId(9L));
       // model.addAttribute("emailAccount", credentialsRepository.findByEmail("spp.bg@abv.bg"));

       return "patient/patient";
        // return "Greetings from Spring Boot Patients!";
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
        model.addAttribute("patient", patient);
        model.addAttribute("credential", credentials);
        return "register";
    }

//    @PostMapping("/save")
//    public String savePatient(@ModelAttribute PatientEntity patient, Model model) {
//        model.addAttribute("patient", patient);
//    //    return "display_form";
//        return "display_form";
//    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String register(@ModelAttribute("patient") PatientEntity patient,@ModelAttribute("credential") CredentialsEntity credential, Model model) {
        System.out.println("get Name:::"+ patient.getFirstName());
        patientService.save(patient);
        credentialsService.save(credential);
        return "display_form";
    }
 }
