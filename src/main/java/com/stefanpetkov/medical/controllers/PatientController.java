package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.commands.PatientCommand;
import com.stefanpetkov.medical.services.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Slf4j
@RequiredArgsConstructor
@Controller
public class PatientController {

    private final PatientService patientService;


    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String registerNewPatient(@ModelAttribute("patient") PatientCommand patientCommand, Model model) {
        log.info("PatientController::registerNewPatient patient command = {}", patientCommand);
        PatientCommand savedCommand = patientService.saveNewPatient(patientCommand);
        model.addAttribute("patient", savedCommand);
        return "display_form";
    }


}



