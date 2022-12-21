package com.stefanpetkov.medical.domain;


import javax.persistence.*;

@Entity
@Table(name = "credentials")
public class CredentialsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long credentialsId;

    @Column(length = 150, nullable = false, unique = true)
    private String email;

    @Column(length = 150, nullable = false, unique = true)
    private String password;
    //private role UserRole;
}
