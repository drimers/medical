package com.stefanpetkov.medical.repositories;

import com.stefanpetkov.medical.domain.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    List<Appointment> findAppointmentEntitiesByPatient_Id(Long patientId);

    List<Appointment> findAppointmentEntitiesByDoctor_Id(Long doctorId);

    List<Appointment> findAllByDoctor_FirstNameOrDoctor_LastName(String firstName, String lastName);

    //todo test
    List<Appointment> findAllByPatientIdAndDoctor_FirstNameOrDoctor_LastName(Long patientId, String docFirstName, String docLastNme);

}
