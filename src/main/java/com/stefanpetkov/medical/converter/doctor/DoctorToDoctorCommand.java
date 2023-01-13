package com.stefanpetkov.medical.converter.doctor;

import com.stefanpetkov.medical.commands.DoctorCommand;
import com.stefanpetkov.medical.domain.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DoctorToDoctorCommand implements Converter<Doctor, DoctorCommand> {


    @Override
    public DoctorCommand convert(Doctor source) {
        return null;
    }
}
