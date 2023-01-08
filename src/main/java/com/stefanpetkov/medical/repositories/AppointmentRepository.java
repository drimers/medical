package com.stefanpetkov.medical.repositories;

import com.stefanpetkov.medical.domain.AppointmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentEntity, Long> {

    List<AppointmentEntity> findAppointmentEntitiesByPatient_Id(Long patientId);

    List<AppointmentEntity> findAppointmentEntitiesByDoctor_Id(Long doctorId);

}
