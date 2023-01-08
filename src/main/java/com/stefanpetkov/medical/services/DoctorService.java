package com.stefanpetkov.medical.services;



import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService{

    private CredentialsRepository credentialsRepository;
    private DoctorRepository doctorRepository;


    @Autowired
    public DoctorService(CredentialsRepository credentialsRepository, DoctorRepository doctorRepository) {
        this.credentialsRepository = credentialsRepository;
        this.doctorRepository = doctorRepository;
    }

    public void save(DoctorEntity doctor) {
        doctorRepository.save(doctor);
    }

}
