package com.example.springApp.controller;

import com.example.springApp.service.CertificateOfIllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class UserProfileController {

    @GetMapping("/patient")
    public String getPatientProfile(Model model) {
        return "patientInfo";
    }

    @GetMapping()
    public String getDoctorProfile() {
        return "doctor";
    }
}
