package com.stefanpetkov.medical.repositories;

import com.stefanpetkov.medical.domain.AppointmentEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentEntity, Long> {

    AppointmentEntity findByAppointmentId (Long appointmentId);
   // AppointmentEntity findAppointemtByAppointemntId (Long appointmentId);
    //AppointmentEntity findAllByPatientId (Long patientId);
}
