package com.stefanpetkov.medical.repositories;

import com.stefanpetkov.medical.domain.CredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialsRepository extends JpaRepository<CredentialsEntity, Long> {


    CredentialsEntity findByCredentialsId  (Long credentialsId);
    CredentialsEntity findByEmail (String email);
    CredentialsEntity findByEmailAndPassword (String email, String Password);

}
