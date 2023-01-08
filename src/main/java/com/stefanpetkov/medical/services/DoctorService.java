package com.stefanpetkov.medical.services;


import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;


    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public void save(DoctorEntity doctor) {
        log.info("DoctorService:: save()");
        doctorRepository.save(doctor);
    }

}
