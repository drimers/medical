package com.stefanpetkov.medical.services;


import com.stefanpetkov.medical.WebConfiguration;
import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService{

    private CredentialsRepository credentialsRepository;
    private DoctorRepository doctorRepository;
    private WebConfiguration webConfiguration;

    public DoctorService(CredentialsRepository credentialsRepository, DoctorRepository doctorRepository, WebConfiguration webConfiguration) {
        this.credentialsRepository = credentialsRepository;
        this.doctorRepository = doctorRepository;
        this.webConfiguration = webConfiguration;
    }

    public void save(DoctorEntity doctor) {
        doctorRepository.save(doctor);
    }

}
