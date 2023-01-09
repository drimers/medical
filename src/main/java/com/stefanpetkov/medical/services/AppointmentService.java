package com.stefanpetkov.medical.services;


import com.stefanpetkov.medical.domain.AppointmentEntity;
import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.repositories.AppointmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


    public List<AppointmentEntity> findAll() {
        Iterable<AppointmentEntity> all = appointmentRepository.findAll();
        List<AppointmentEntity> entities = new ArrayList<>();
        all.iterator().forEachRemaining(entities::add);
        return entities;
    }

    public List<DoctorEntity> findAllDoctorsByPatientId(Long patientId) {
        List<AppointmentEntity> appointmentEntities = appointmentRepository.findAppointmentEntitiesByPatient_Id(patientId);
        List<DoctorEntity> doctorEntities = new ArrayList<>();
        appointmentEntities.forEach(appointment -> {
            doctorEntities.add(appointment.getDoctor());
        });
        return doctorEntities;
    }


    public List<PatientEntity> findAllPatientsByDoctorId(Long doctorId) {
        List<AppointmentEntity> appointmentEntities = appointmentRepository.findAppointmentEntitiesByDoctor_Id(doctorId);
        List<PatientEntity> patientEntities = new ArrayList<>();
        appointmentEntities.forEach(appointment -> {
            patientEntities.add(appointment.getPatient());
        });
        return patientEntities;
    }

    public List<AppointmentEntity> findAppointmentEntitiesByDoctor_Id(Long doctorID) {
        //List<AppointmentEntity> appointmentEntities = appointmentRepository.findAllAppointmentByPatient_Id(patientId);
        List<AppointmentEntity> appointmentEntities = appointmentRepository.findAppointmentEntitiesByDoctor_Id(doctorID);
        List<AppointmentEntity> entities = new ArrayList<>();
        appointmentEntities.iterator().forEachRemaining(entities::add);
        return entities;
    }

    public List<AppointmentEntity> findAppointmentEntitiesByPatient_Id(Long patientID) {
        //List<AppointmentEntity> appointmentEntities = appointmentRepository.findAllAppointmentByPatient_Id(patientId);
        List<AppointmentEntity> appointmentEntities = appointmentRepository.findAppointmentEntitiesByPatient_Id(patientID);
        List<AppointmentEntity> entities = new ArrayList<>();
        appointmentEntities.iterator().forEachRemaining(entities::add);
        return entities;
    }
        // select * from APPOINTMENT as A join doctor as D on A.doctor_id=D.user_id  where A.patient_id=2;

}