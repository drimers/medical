package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.domain.AppointmentEntity;
import com.stefanpetkov.medical.domain.CredentialsEntity;
import com.stefanpetkov.medical.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class AppointmentController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }





//    @PostMapping(path = "/patient/addAppointment")
//    public String addappointment(//@RequestParam(value = "firstName") String firstName,
//                           //  @RequestParam(value= "lastName") String lastName,
//                             @RequestParam(value= "appointment") String appointment,
//                                                        HttpSession session) {
//
//        CredentialsEntity user = (CredentialsEntity)session.getAttribute("loggedUser");
//
//        if(user != null) {
//
//            AppointmentEntity appointments =
//                    appointmentService.addAppointment(
//                           // firstName, lastName,
//                            appointment);
//
//            if(appointments != null) {
//                //return String.valueOf(comment.getId());
//                return appointments.getAppointmentId() + "";
//            }
//
//            return "Error: comment post caput....";
//
//        }
//
//        return "Error: Please log in to post comment... duh...";
//    }

//    @GetMapping(path = "/comment/all")
//    public ResponseEntity<List<CommentEntity>>
//    getAllComments(HttpSession session) {
//
//        UserEntity user = (UserEntity)session.getAttribute("loggedUser");
//
//        if(user != null) {
//
//            return new ResponseEntity<List<CommentEntity>>
//                    (commentService.getAll(), HttpStatus.OK);
//
//        }
//        return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
//    }


}
