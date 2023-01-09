package com.stefanpetkov.medical.bootstrap;

import com.stefanpetkov.medical.domain.AppointmentEntity;
import com.stefanpetkov.medical.domain.CredentialsEntity;
import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.domain.Role;
import com.stefanpetkov.medical.repositories.AppointmentRepository;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import com.stefanpetkov.medical.util.ApplicationConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
        log.info("Executing Bootstrap!");
        loadData();
        log.info("Bootstrap completed!");
    }

    private void loadData() {
        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Ivan");
        doctor.setLastName("Ivanov");
        doctor.setPhone("08987777777");
        log.info("Doctor created = {}", doctor);
        doctorRepository.save(doctor);

        log.info("Doctors");
        log.info("Number of doctors = {}", doctorRepository.count());

        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Stefan");
        patient.setLastName("Stefanov");
        patient.setPhone("0893343333");
        patient.setComment("Any comments!!!");
        log.info("Patient created = {}", patient);
        //patientRepository.save(patient);

        log.info("Patients");
        log.info("Number of patients = {}", patientRepository.count());


        CredentialsEntity credentials = new CredentialsEntity();
        credentials.setEmail("spp1.bg@abv.bg");
        credentials.setPassword("pass");
        credentials.setRole(Role.PATIENT);
        patient.setCredentials(credentials);
        credentials.setBaseUser(patient);
        patientRepository.save(patient);
        credentialsRepository.save(credentials);

        log.info("Credentials");
        log.info("Number of credential  = {}", credentialsRepository.count());


        AppointmentEntity appointment = new AppointmentEntity();
        LocalDateTime ldt = LocalDateTime.of(2023, 1, 9, 13, 5);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ApplicationConstants.DAY_MONTH_YEAR_HOUR_MINUTE_FORMATTER);
        log.info("Formatted date = {}", dtf.toString());
        appointment.setDateTimeOfTheAppointment(ldt);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        log.info("Appointment = {}", appointment);
        appointmentRepository.save(appointment);

        log.info("Appointments");
        log.info("Number of appointments = {}", appointmentRepository.count());
    }

    private void createPatients() {

    }


    private void createDoctors() {

    }

}
