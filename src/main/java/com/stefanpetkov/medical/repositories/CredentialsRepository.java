package com.stefanpetkov.medical.repositories;

import com.stefanpetkov.medical.domain.CredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsRepository extends CrudRepository<CredentialsEntity, Long> {

    //CredentialsEntity find
}
