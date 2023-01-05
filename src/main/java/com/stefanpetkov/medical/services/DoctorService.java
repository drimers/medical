package com.stefanpetkov.medical.services;


import com.stefanpetkov.medical.config.SecurityConfiguration;
import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.stereotype.Service;

@Service
public class DoctorService{

    private CredentialsRepository credentialsRepository;
    private DoctorRepository doctorRepository;
    private SecurityConfiguration securityConfiguration;

    @Autowired
    public DoctorService(CredentialsRepository credentialsRepository, DoctorRepository doctorRepository, SecurityConfiguration securityConfiguration) {
        this.credentialsRepository = credentialsRepository;
        this.doctorRepository = doctorRepository;
        this.securityConfiguration = securityConfiguration;
    }

    public void save(DoctorEntity doctor) {
        doctorRepository.save(doctor);
    }

}
