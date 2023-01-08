package com.stefanpetkov.medical.domain;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "doctor")
public class DoctorEntity  implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 50)
    private String phone;
    @Lob
    private Byte[] profilePicture;

    @OneToOne(cascade = CascadeType.ALL)
    private CredentialsEntity credentials;
    @Enumerated(value = EnumType.STRING)
    private Role role;

    //    @OneToMany(mappedBy = "doctor") // inverse side: it has a mappedBy attribute, and can't decide how the association is mapped, since the other side already decided it.
//    @Fetch(FetchMode.JOIN)
//    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private Set<WorkingDayEntity> workingDay;


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
    public String toString() {
        return "DoctorEntity{" +
                "doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", profilePicture=" + Arrays.toString(profilePicture) +
                ", credentials=" + credentials +
                ", role=" + role +
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
