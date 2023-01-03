package com.stefanpetkov.medical.services;


import com.stefanpetkov.medical.WebConfiguration;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import org.springframework.stereotype.Service;


@Service
public class PatientService {

       private  CredentialsRepository credentialsRepository;
       private PatientRepository patientRepository;
       private WebConfiguration webConfiguration;

    public PatientService(CredentialsRepository credentialsRepository, PatientRepository patientRepository, WebConfiguration webConfiguration) {
        this.credentialsRepository = credentialsRepository;
        this.patientRepository = patientRepository;
        this.webConfiguration = webConfiguration;
    }
}
