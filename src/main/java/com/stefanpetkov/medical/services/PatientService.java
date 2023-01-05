package com.stefanpetkov.medical.services;


import com.stefanpetkov.medical.config.SecurityConfiguration;
import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PatientService {

       private  CredentialsRepository credentialsRepository;
       private PatientRepository patientRepository;
       private SecurityConfiguration securityConfiguration;

    @Autowired
    public PatientService(CredentialsRepository credentialsRepository, PatientRepository patientRepository, SecurityConfiguration securityConfiguration) {
        this.credentialsRepository = credentialsRepository;
        this.patientRepository = patientRepository;
        this.securityConfiguration = securityConfiguration;
    }
       public void save(PatientEntity patient) {
        patientRepository.save(patient);
    }


}
