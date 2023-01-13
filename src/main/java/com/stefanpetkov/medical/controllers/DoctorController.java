package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.services.DoctorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;


@Slf4j
@Controller
@RequiredArgsConstructor
public class DoctorController {


    private final DoctorService doctorService;

}
