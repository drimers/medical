package com.stefanpetkov.medical.domain;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "appointment")
public class AppointmentEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    //@DateTimeFormat(pattern = "dd-MM.yyyy")
    //private LocalDate appointmentDate;

    @Column(length = 50, nullable = false)
    private String appointment;


    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;


    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;


    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
        doctor.addAnAppointment(this);
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
        patient.addAnAppointment(this);
    }

    @Override
    public String toString() {
        return "AppointmentEntity{" +
                "appointmentId=" + appointmentId +
                ", appointment='" + appointment + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppointmentEntity that = (AppointmentEntity) o;

        return Objects.equals(appointmentId, that.appointmentId);
    }

    @Override
    public int hashCode() {
        return appointmentId != null ? appointmentId.hashCode() + 17 : 53;
    }
}
