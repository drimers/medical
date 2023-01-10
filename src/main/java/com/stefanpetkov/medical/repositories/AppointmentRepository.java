package com.stefanpetkov.medical.repositories;

import com.stefanpetkov.medical.domain.AppointmentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentEntity, Long> {

    List<AppointmentEntity> findAppointmentEntitiesByPatient_Id(Long patientId);

    List<AppointmentEntity> findAppointmentEntitiesByDoctor_Id(Long doctorId);

  //  public List<AppointmentEntity> findAppointmentEntitiesByPatient_IdEqualUserIdInDoctorsEntity(Long patientID) {
        @Query(value = "select * from APPOINTMENT as A join doctor as D on A.doctor_id=D.user_id  where A.patient_id= :patient_id", nativeQuery = true)
        List<AppointmentEntity> findAppointmentEntitiesByPatient_IdEqualUserIdInDoctorsEntity (Long patient_id);


        //select  *  from APPOINTMENT as A join PATIENT as P on A.patient_id=P.user_id  where A.doctor_id=1;
        @Query(value = "select  *  from APPOINTMENT as A join PATIENT as P on A.patient_id=P.user_id  where A.doctor_id= :doctor_id", nativeQuery = true)
        List<AppointmentEntity> findAppointmentEntitiesByPatient_IdEqualUserIdInPatientEntity (Long doctor_id);
}
