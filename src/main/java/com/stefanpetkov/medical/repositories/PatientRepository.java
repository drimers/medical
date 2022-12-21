package com.stefanpetkov.medical.repositories;

import com.stefanpetkov.medical.domain.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository  extends JpaRepository<PatientEntity, Long> {

    PatientEntity findPatientByPatientId (Long patientId);

   // PatientEntity find

  }
