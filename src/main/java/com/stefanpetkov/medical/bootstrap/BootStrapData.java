package com.stefanpetkov.medical.bootstrap;

import com.stefanpetkov.medical.domain.CredentialsEntity;
import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final CredentialsRepository credentialsRepository;

    public BootStrapData(DoctorRepository doctorRepository, PatientRepository patientRepository,
                         CredentialsRepository credentialsRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.credentialsRepository = credentialsRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       // loadData();

    }

    private void loadData() {
        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Ivan");
        doctor.setLastName("Ivanov");
        doctor.setPhone("08987777777");
        doctor.getFirstName();
        doctor.getLastName();
        doctor.getPhone();
        doctorRepository.save(doctor);

        System.out.println("Doctors");
        System.out.println("number of doctors " +  doctorRepository.count());

        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Stefan");
        patient.setLastName("Stefanov");
        patient.setPhone("0893343333");
        patient.setComment("Any comments!!!");
        patient.getFirstName();
        patient.getLastName();
        patient.getPhone();
        patient.getComment();
        patientRepository.save(patient);

        System.out.println("patient");
        System.out.println("number of patient " +  patientRepository.count());


        CredentialsEntity credentials = new CredentialsEntity();
        credentials.setEmail("spp.bg@abv.bg");
        credentials.setPassword("pass");
        credentials.setCredentialsId(5L);
        credentials.getPatient();
        credentials.getEmail();
        credentialsRepository.save(credentials);
        System.out.println("credential");
        System.out.println("number of credential " +  credentialsRepository.count());
    }


}
