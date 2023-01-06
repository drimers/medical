package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.domain.*;
import com.stefanpetkov.medical.repositories.AppointmentRepository;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import com.stefanpetkov.medical.services.AppointmentService;
import com.stefanpetkov.medical.services.CredentialsService;
import com.stefanpetkov.medical.services.DoctorService;
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

    private final DoctorService doctorService;

    private final AppointmentService appointmentService;


    @Autowired
    public PatientController(PatientRepository patientRepository, CredentialsRepository credentialsRepository,
                             DoctorRepository doctorRepository, AppointmentRepository appointmentRepository, PatientService patientService, CredentialsService credentialsService, DoctorService doctorService, AppointmentService appointmentService) {
        this.patientRepository = patientRepository;
        this.credentialsRepository = credentialsRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.patientService = patientService;
        this.credentialsService = credentialsService;
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
    }



    @RequestMapping("/patient")
    public String getDoctor( Model model) {
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("appointment", appointmentRepository.findByAppointmentId(1L));

      //  model.addAttribute("appointment", appointmentRepository.findAllByPatientId(9L));
       // model.addAttribute("emailAccount", credentialsRepository.findByEmail("spp.bg@abv.bg"));

       return "patient/patient";
        // return "Greetings from Spring Boot Patients!";
    }


    // Form registration

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String register(@ModelAttribute("doctors") DoctorEntity doctor, @ModelAttribute("appointment") AppointmentEntity appointment, Model model) {
        System.out.println("get appointment:::"+ appointment.getAppointment());
       // doctorService.save(doctor);
        model.addAttribute("appointment", appointment);
        appointmentService.save(appointment);
        return "patient/patient";
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


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String register(@ModelAttribute("patient") PatientEntity patient, @ModelAttribute("doctor") DoctorEntity doctor, @ModelAttribute("credential") CredentialsEntity credential, Model model) {
        System.out.println("get UserName:::"+ patient.getFirstName());

        if( patient.getRole() == Role.PATIENT) {
            patient.setCredentials(credential);
            patientService.save(patient);
//            credentialsService.save(credential);
            return "display_form";
        } else if(patient.getRole() == Role.DOCTOR){
            System.out.println("Doctor registration");
            doctor.setFirstName(patient.getFirstName());
            doctor.setLastName(patient.getLastName());
            doctor.setPhone(patient.getPhone());
            doctor.setRole(patient.getRole());

//            doctor.getFirstName();
//            doctor.getLastName();
//            doctor.getPhone();
//            doctor.getRole();
           // doctorRepository.save(doctor);
            doctorService.save(doctor);
            credentialsService.save(credential);
            return "display_form";
        }
        return "display_form";
    }




//    @PostMapping("/save")
//    public String savePatient(@ModelAttribute PatientEntity patient, Model model) {
//        model.addAttribute("patient", patient);
//    //    return "display_form";
//        return "display_form";
//    }





 }
