package com.stefanpetkov.medical.converter.doctor;

import com.stefanpetkov.medical.commands.AppointmentCommand;
import com.stefanpetkov.medical.commands.DoctorCommand;
import com.stefanpetkov.medical.domain.Appointment;
import com.stefanpetkov.medical.domain.Doctor;
import com.stefanpetkov.medical.domain.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@Component
public class DoctorToDoctorCommand implements Converter<Doctor, DoctorCommand> {


    @Override
    public DoctorCommand convert(Doctor doctor) {
        log.info("Converting appointment to command = {}", doctor);

        validate(doctor);

        Set<Appointment> appointment = doctor.getAppointments();
     //   Patient patient = doctor.getPatient();

        DoctorCommand command = new DoctorCommand();
        command.setDoctorId(doctor.getId());
        command.setDoctorFirstName(doctor.getFirstName());
        command.setDoctorLastName(doctor.getLastName());
      //  command.setDoctorPhoneNumber(doctor.getPhone());

       // command.setPatientId(patient.getId());
//        command.setPatientFirstName(patient.getFirstName());
//        command.setPatientLastName(patient.getLastName());
//        command.setPatientPhoneNumber(patient.getPhone());
//        command.setPatientComment(patient.getComment());

        log.info("Command converted = {}", command);

        return command;

    }

    private void validate(Doctor doctor) {
        String errorMessage = "";
//        if (doctor == null) {
//            errorMessage = "Passed doctor is NULL!";
//            log.error(errorMessage);
//            throw new RuntimeException(errorMessage);
//        }
//        if (doctor.getDoctor() == null) {
//            errorMessage = "Passed doctor without doctor!";
//            log.error(errorMessage);
//            throw new RuntimeException(errorMessage);
//        }
//        if (doctor.getPatient() == null) {
//            errorMessage = "Passed doctor without patient!";
//            log.error(errorMessage);
//            throw new RuntimeException(errorMessage);
//        }
    }
}
