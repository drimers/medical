package com.stefanpetkov.medical.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "doctor")
@Data
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 50)
    private String phone;

    @Column(name = "profilePicture", length = 400)
    private String profilePicture;

    public DoctorEntity(String firstName, String lastName) {
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
    @JoinColumn(name = "doctor_id")
    private CredentialsEntity credentials;


//    @OneToMany(mappedBy = "doctor") // inverse side: it has a mappedBy attribute, and can't decide how the association is mapped, since the other side already decided it.
//    @Fetch(FetchMode.JOIN)
//    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "doctor_id")
    private List<WorkingDayEntity> workingDay;




    @Override
    public String toString() {
        return "DoctorEntity{" +
                "doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", credentials=" + credentials +
                ", workingDay=" + workingDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoctorEntity that = (DoctorEntity) o;

        return Objects.equals(doctorId, that.doctorId);
    }

    @Override
    public int hashCode() {
        return doctorId != null ? doctorId.hashCode() : 0;
    }
}
