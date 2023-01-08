package com.stefanpetkov.medical.repositories;

import com.stefanpetkov.medical.domain.AppointmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentEntity, Long> {

}
