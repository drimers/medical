package com.stefanpetkov.medical.domain;

import javax.persistence.*;

@Entity
@Table(name = "workingday")
public class WorkingDayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workingDayId;

    @Column(length = 50, nullable = false)
    private String workingDay;

    @Column(length = 50, nullable = false)
    private String startTime;

    @Column(length = 50, nullable = false)
    private String endTime;


}
