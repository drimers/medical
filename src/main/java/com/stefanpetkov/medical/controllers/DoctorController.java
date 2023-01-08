package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.repositories.AppointmentRepository;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import com.stefanpetkov.medical.util.ApplicationConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping(ApplicationConstants.REQUEST_MAPPING_DOCTOR)
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


    @RequestMapping
    public String getPatient(Model model) {
        log.info("DoctorController::getPatient");
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("appointment", appointmentRepository.findById(1L));
        return ApplicationConstants.VIEW_NAME_DOCTORS;
    }


//        @GetMapping("/doctors")
//        public List<PatientEntity> getAllPatient() {
//            return patientRepository.findAllBy();
//        }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<PatientEntity> getEmployeeById(@PathVariable(value = "id") Long patientId) throws ResourceNotFoundException {
        PatientEntity patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + patientId));
        return ResponseEntity.ok().body(patient);
    }


}
