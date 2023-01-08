package com.stefanpetkov.medical.bootstrap;

import com.stefanpetkov.medical.domain.AppointmentEntity;
import com.stefanpetkov.medical.domain.CredentialsEntity;
import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.repositories.AppointmentRepository;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class BootStrapData implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final CredentialsRepository credentialsRepository;

    private final AppointmentRepository appointmentRepository;


    public BootStrapData(DoctorRepository doctorRepository, PatientRepository patientRepository,
                         CredentialsRepository credentialsRepository, AppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.credentialsRepository = credentialsRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadData();

    }

    private void loadData() {
        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Ivan");
        doctor.setLastName("Ivanov");
        doctor.setPhone("08987777777");
        doctorRepository.save(doctor);

        log.info("Doctors");
        log.info("Number of doctors = {}", doctorRepository.count());

        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Stefan");
        patient.setLastName("Stefanov");
        patient.setPhone("0893343333");
        patient.setComment("Any comments!!!");
        patientRepository.save(patient);

        log.info("Patients");
        log.info("Number of patients = {}", patientRepository.count());


        CredentialsEntity credentials = new CredentialsEntity();
        credentials.setEmail("spp1.bg@abv.bg");
        credentials.setPassword("pass");
        credentials.setCredentialsId(5L);
        credentialsRepository.save(credentials);

        log.info("Credentials");
        log.info("Number of credential  = {}", credentialsRepository.count());


        AppointmentEntity appointment = new AppointmentEntity();
        appointment.setAppointment("03.01.2023");
        //appointment.setPatient(patientRepository.findPatientByPatientId(1L));
        // appointment.getPatient();
        appointmentRepository.save(appointment);

        log.info("Appointments");
        log.info("Number of appointments = {}", appointmentRepository.count());
    }


}
