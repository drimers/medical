package com.stefanpetkov.medical.commands;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class DoctorCommand {

    //doctor
    private Long doctorId;
    private String doctorFirstName;
    private String doctorLastName;
    private String doctorPhone;

    //patient
    private Long patientId;

    //appointment
    private Long appointmentId;
    private LocalDateTime dateTimeOfTheAppointment;


}
