package com.stefanpetkov.medical.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "credentials")
@Data
public class CredentialsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long credentialsId;

    @Column(length = 150, nullable = false, unique = true)
    private String email;

    @Column(length = 150, nullable = false, unique = true)
    private String password;
    //private role UserRole;


    @OneToOne
    private PatientEntity patient;

    @OneToOne
    private DoctorEntity doctor;

    /*
    relationship OneToOne {
        Patient{credentials(credentialsId)} to Credentials{patient(patientId)}
        Credentials{patient(patientId)} to Patient{credentials(credentialsId)}
        Doctor{credentials(credentialsId)} to Credentials{doctor(doctorId)}
        Credentials{doctor(doctorId)} to Doctor{credentials(credentialsId)}
    }

    relationship OneToMany {
        Patient{appointmentList(appointmentId)} to Appointment{patient(patientId)}
        Doctor{appointmentList(appointmentId)} to Appointment{doctor(doctorId)}
        Doctor{workingDayList(appointmentId)} to WorkingDay{doctor(doctorId)}
    }

*/



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CredentialsEntity that = (CredentialsEntity) o;

        return Objects.equals(credentialsId, that.credentialsId);
    }

    @Override
    public int hashCode() {
        return credentialsId != null ? credentialsId.hashCode() : 0;
    }
}
