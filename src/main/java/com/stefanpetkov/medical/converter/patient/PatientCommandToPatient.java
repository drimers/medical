package com.stefanpetkov.medical.converter.patient;

import com.stefanpetkov.medical.commands.PatientCommand;
import com.stefanpetkov.medical.domain.Patient;
import com.stefanpetkov.medical.domain.Role;
import com.stefanpetkov.medical.domain.UserCredentials;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class PatientCommandToPatient implements Converter<PatientCommand, Patient> {


    private final PatientRepository patientRepository;
    private final CredentialsRepository credentialsRepository;


    @Override
    public Patient convert(PatientCommand command) {
        log.info("Converting command to patient = {}", command);
        validate(command);

        Optional<Patient> patientOptional = Optional.empty();
        if (command.getPatientId() != null) {
            patientOptional = patientRepository.findById(command.getPatientId());
        }

        Patient patient;
        if (patientOptional.isPresent()) {
            //todo handle setting needed values, except credentials
            return patientOptional.get();
        }

        patient = new Patient();
        patient.setFirstName(command.getFirstName());
        patient.setLastName(command.getLastName());
        patient.setPhone(command.getPhone());
        patient.setComment(command.getComment());

        //todo check if there is already user with the sme username

        UserCredentials patientCredentials = new UserCredentials();
        patientCredentials.setEmail(command.getEmail());
        patientCredentials.setPassword(command.getPassword());
        patientCredentials.setRole(Role.PATIENT);

        patient.setCredentials(patientCredentials);
        patientCredentials.setBaseUser(patient);


        log.info("Patient converted = {}", patient);
        return patient;
    }

    private void validate(PatientCommand command) {
        String errorMessage = "";
        if (command == null) {
            if (command == null) {
                errorMessage += "Command is NULL!";
                log.error(errorMessage);
                throw new RuntimeException(errorMessage);
            }
            //todo validate other fields too, create custom Exception class
        }
    }
}
