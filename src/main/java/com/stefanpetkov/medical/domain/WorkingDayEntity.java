package com.stefanpetkov.medical.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@Table(name = "workingday")
public class WorkingDayEntity  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workingDayId;

    @Column(length = 50, nullable = false)
    private String workingDay;

    @Column(length = 50, nullable = false)
    private String startTime;

    @Column(length = 50, nullable = false)
    private String endTime;

    // @ManyToOne
    //  @JoinTable(name = "doctor_workingday",
    //  joinColumns={@JoinColumn(name="doctor_id")},
    //  inverseJoinColumns={@JoinColumn(name="workingday_id")})
    @ManyToOne
    private  DoctorEntity doctor;


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

        WorkingDayEntity that = (WorkingDayEntity) o;

        return Objects.equals(workingDayId, that.workingDayId);
    }

    @Override
    public int hashCode() {
        return workingDayId != null ? workingDayId.hashCode() : 0;
    }
}
