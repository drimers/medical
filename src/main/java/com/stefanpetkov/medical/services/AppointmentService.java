package com.stefanpetkov.medical.services;


import com.stefanpetkov.medical.domain.AppointmentEntity;
import com.stefanpetkov.medical.repositories.AppointmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AppointmentService {


    private final AppointmentRepository appointmentRepository;


    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }



    public void save(AppointmentEntity appointment) {
        log.info("AppointmentService:: save()");
        appointmentRepository.save(appointment);
    }


}