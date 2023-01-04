package com.stefanpetkov.medical.services;


import com.stefanpetkov.medical.WebConfiguration;
import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PatientService {

       private  CredentialsRepository credentialsRepository;
       private PatientRepository patientRepository;
       private WebConfiguration webConfiguration;

    @Autowired
    public PatientService(CredentialsRepository credentialsRepository, PatientRepository patientRepository, WebConfiguration webConfiguration) {
        this.credentialsRepository = credentialsRepository;
        this.patientRepository = patientRepository;
        this.webConfiguration = webConfiguration;
    }
       public void save(PatientEntity patient) {
        patientRepository.save(patient);
    }


}
