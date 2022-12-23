package com.stefanpetkov.medical.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @Column(length = 50)
    private String phone;

    @Column(name = "profilePicture", length = 400)
    private String profilePicture;


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
    private CredentialsEntity credentials;

    @ManyToOne
 //   @OneToMany(mappedBy = "doctor") // inverse side: it has a mappedBy attribute, and can't decide how the association is mapped, since the other side already decided it.
 //   @Fetch(FetchMode.JOIN)
 //   @JsonIgnore
    private WorkingDayEntity workingDay;







}
