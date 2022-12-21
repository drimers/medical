package com.stefanpetkov.medical.repositories;

import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

    DoctorEntity findDoctorByDoctorId (Long doctorId);


}
