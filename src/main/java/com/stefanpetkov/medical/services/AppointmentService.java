package com.stefanpetkov.medical.services;


import com.stefanpetkov.medical.domain.AppointmentEntity;
import com.stefanpetkov.medical.domain.CredentialsEntity;
import com.stefanpetkov.medical.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentEntity addAppointment(String date) {

        AppointmentEntity appointment = new AppointmentEntity();
        appointment.setAppointment(date);
       // appointment.setPatient(user);
        appointment.getAppointment();

        return appointmentRepository.save(appointment);
    }
}
