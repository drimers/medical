package com.stefanpetkov.medical.domain;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @Column(length = 50, nullable = false, unique = true)
    private String firstName;

    @Column(length = 50, nullable = false, unique = true)
    private String lastName;

    @Column(length = 50)
    private String phone;

    @Column(length = 2500)
    private String comment;


}
