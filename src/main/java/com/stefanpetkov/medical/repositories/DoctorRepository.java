package com.stefanpetkov.medical.repositories;

import com.stefanpetkov.medical.domain.DoctorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<DoctorEntity, Long> {

}
