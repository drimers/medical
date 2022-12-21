package com.stefanpetkov.medical.domain;


import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @Column(length = 50, nullable = false, unique = true)
    private String firstName;

    @Column(length = 50, nullable = false, unique = true)
    private String lastName;

    private String phone;

}
