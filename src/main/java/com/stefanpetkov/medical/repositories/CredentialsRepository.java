package com.stefanpetkov.medical.repositories;

import com.stefanpetkov.medical.domain.CredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<CredentialsEntity, Long> {

    //CredentialsEntity find
}
