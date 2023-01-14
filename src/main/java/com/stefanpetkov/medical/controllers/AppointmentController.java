package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.commands.AppointmentCommand;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.services.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, DoctorRepository doctorRepository) {
        this.appointmentService = appointmentService;
    }

    @RequestMapping(path = {"/searchByDoctorName"})
    public String searchAppointmentByDoctorName(AppointmentCommand command, Model model, @RequestParam String name) {
        log.info("AppointmentController::searchAppointmentByDoctorName name passed = {}", name);
        List<AppointmentCommand> commands = appointmentService.searchAppointmentByDoctorName(name);
        model.addAttribute("appointments", commands);
        return "patient/patientAppointments";
    }


    @RequestMapping(path = "/patient")//TODO fix hardcoded ID with path variable for patient after logged in
    public String findAllAppointmentsForPatient(Model model) {
        log.info("AppointmentController::findAllAppointmentsForPatient");
        List<AppointmentCommand> patientAppointments = appointmentService.appointmentsForPatient(2L);
        model.addAttribute("appointments", patientAppointments);
        return "patient/patientAppointments";
    }

    @RequestMapping(path = "/doctor")// TODO fix hardcoded ID with path variable for doctor after logged in
    public String findAllAppointmentsForDoctor(Model model) {
        log.info("AppointmentController::findAllAppointmentsForDoctor");
        List<AppointmentCommand> doctorAppointments = appointmentService.appointmentsForDoctor(1L);
        model.addAttribute("appointments", doctorAppointments);
        return "doctor/doctorAppointments";
    }


    @RequestMapping(path = "/addAppointment")
    public String showAppointmentForm(@ModelAttribute("appointment") AppointmentCommand appointment, Model model) {
        log.info("AppointmentController::showAppointmentForm, command = {}", appointment);
        model.addAttribute("appointment", appointment);
       return "appointment";
    }


    @RequestMapping(value = "/saveAppointment", method = RequestMethod.POST)
    public String saveAppointment(@ModelAttribute("appointment") AppointmentCommand appointment) {
        log.info("AppointmentController :: updateAppointment  appointment = {} ", appointment);
        appointmentService.save(appointment);
        return "redirect:/patient";
    }

    @GetMapping(path = "updateAppointmentForm")
    public String showUpdateAppointmentForm(Model model, @RequestParam Long appointment_id) {
        log.info("AppointmentController::updateAppointmentForm appointment ID = {}", appointment_id);
        AppointmentCommand appointment = appointmentService.findById(appointment_id);
        log.info("Retrieved command = {}", appointment);
        model.addAttribute("appointment", appointment);
        return "updateAppointment";
    }


    @RequestMapping(value = "/updateAppointment", method = RequestMethod.POST)
    public String updateAppointment(@ModelAttribute("appointment") AppointmentCommand appointment) {
        log.info("AppointmentController :: updateAppointment  appointment = {} ", appointment);
        appointmentService.update(appointment);
        return "redirect:/patient";
    }


    @GetMapping("/deleteAppointment")
    public String deleteAppointment(@RequestParam Long appointment_id) {
        log.info("AppointmentController::deleteAppointment appointment ID = {}", appointment_id);
        appointmentService.deleteById(appointment_id);
        return "redirect:/patient";
    }


}
