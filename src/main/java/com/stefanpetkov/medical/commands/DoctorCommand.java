package com.stefanpetkov.medical.commands;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DoctorCommand {

    private Long doctorId;
    private String firstName;
    private String lastName;
    private String phone;


}
