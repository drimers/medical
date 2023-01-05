package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.domain.CredentialsEntity;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.services.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CredentialsController {

    private final CredentialsService credentialsService;

    private final CredentialsRepository credentialsRepository;

    @Autowired
    public CredentialsController(CredentialsService credentialsService, CredentialsRepository credentialsRepository) {
        this.credentialsService = credentialsService;
        this.credentialsRepository = credentialsRepository;
    }


//    @GetMapping("/login")
//    String login() {
//        return "login";
//    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
//        PatientEntity patient = new PatientEntity();
        CredentialsEntity credentials = new CredentialsEntity();
//        List<String> role = new ArrayList<>();
//        role.add("Patient");
//        role.add("Doctor");
//        model.addAttribute("roles", role);
//        model.addAttribute("patient", patient);
        model.addAttribute("credential", credentials);
        return "login";
    }


    @RequestMapping(value = "/logon", method = RequestMethod.POST)
    public String login(@ModelAttribute("credential") CredentialsEntity credentials, Model model) {
        System.out.println("get Email:::" + credentials.getEmail());
        // String username = String.valueOf(credentialsRepository.findByEmail(credentials.getEmail()));

        CredentialsEntity username = credentialsRepository.findByEmail(credentials.getEmail());

        System.out.println("Email : " + credentials.getEmail());
        System.out.println("Email Password : " + credentials.getPassword());

        if (username != null) {
        System.out.println("username : " + username.getEmail());
        System.out.println("Password : " + username.getPassword());


            if ((username.getEmail().equals(credentials.getEmail())) && (username.getPassword().equals(credentials.getPassword()))) {
                //credentialsService.save(credentials);
                return "redirect:/patient";
            }
        }
        System.out.println("Username not valid");
        return "login";
    }
}

