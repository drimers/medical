package com.stefanpetkov.medical.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "patient")
@Data
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 50)
    private String phone;

    @Column(length = 2500)
    private String comment;


    private Byte[] profilePicture;

    public PatientEntity() {
    }

    public PatientEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


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



    @OneToOne
    @JoinColumn(name = "patient_id")
    private CredentialsEntity credentials;

    @OneToMany
    @JoinColumn(name = "patient_id")
    private List<AppointmentEntity> appointment;


    @Override
    public String toString() {
        return "PatientEntity{" +
                "patientId=" + patientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", comment='" + comment + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", credentials=" + credentials +
                ", appointment=" + appointment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientEntity that = (PatientEntity) o;

        return Objects.equals(patientId, that.patientId);
    }

    @Override
    public int hashCode() {
        return patientId != null ? patientId.hashCode() : 0;
    }
}
