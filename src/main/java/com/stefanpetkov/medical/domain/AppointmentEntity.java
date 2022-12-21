package com.stefanpetkov.medical.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "appointment")
public class AppointmentEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @Column(length = 50, nullable = false)
    private String appointmentDate;

    @Column(length = 50, nullable = false)
    private String appointmentStartTime;

    @Column(length = 50, nullable = false)
    private String appointmentEndTime;

}
