package com.stefanpetkov.medical.bootstrap;

import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public BootStrapData(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        DoctorEntity doctor = new DoctorEntity("Ivan","Ivanov");
        doctor.getFirstName();
        doctor.getLastName();
        doctorRepository.save(doctor);

        System.out.println("Doctors");
        System.out.println("number of doctors " +  doctorRepository.count());

    }



}
