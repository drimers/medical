package com.stefanpetkov.medical.services;


import com.stefanpetkov.medical.commands.PatientCommand;
import com.stefanpetkov.medical.converter.patient.PatientCommandToPatient;
import com.stefanpetkov.medical.converter.patient.PatientToPatientCommand;
import com.stefanpetkov.medical.domain.Patient;
import com.stefanpetkov.medical.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientCommandToPatient toPatient;
    private final PatientToPatientCommand toPatientCommand;


    public PatientCommand saveNewPatient(PatientCommand command) {
        log.info("PatientService::saveNewPatient passed patient command = {}", command);
        Patient newPatient = toPatient.convert(command);
        //todo evaluate if credentials repo should be called too
        Patient savedPatient = patientRepository.save(newPatient);
        log.info("Saved patient = {}", savedPatient);
        PatientCommand savedCommand = toPatientCommand.convert(savedPatient);
        return savedCommand;
    }

}
