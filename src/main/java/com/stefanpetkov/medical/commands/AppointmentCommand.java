package com.stefanpetkov.medical.commands;

import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class AppointmentCommand implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long appointmentId;

    private Long doctorId;
    private LocalDateTime dateTimeOfTheAppointment;

    private String firstName;

    private String lastName;

}
