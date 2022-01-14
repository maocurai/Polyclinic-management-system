package com.example.springApp.controller;

import com.example.springApp.DTO.PersonDTO;
import com.example.springApp.domain.*;
import com.example.springApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UtilityController controller;

    @Autowired
    private CertificateOfIllnessService certificateOfIllnessService;

    @GetMapping(value = {"", "/find/{doctor}"})
    public String list(@RequestParam(value = "phone", required = false) String phone,
                       @PathVariable(required = false)  Doctor doctor,
                       @RequestParam(value = "doctorId", required = false) Doctor doctorId,
                       Model model) {
        if(phone != null) {
            find(phone, model);
            if(doctorId != null) model.addAttribute("doctor", doctorId);
        } else {
            model.addAttribute("patients", patientService.findAll().stream().filter(x -> !x.isDeleted()).iterator())
                    .addAttribute("doctor", doctor);
        }
        return "patient";
    }

    @GetMapping("/{doctor}/{patient}")
    public String addPatientToDoctor(@PathVariable Patient patient,
                                     @PathVariable Doctor doctor) {
        patientService.addDoctor(patient, doctor);
        doctorService.addPatient(doctor, patient);
        return "redirect:/doctor/info/" + doctor.getId();
    }

    @GetMapping("{patient}")
    public String editForm(@PathVariable Patient patient, Model model) {
        controller.fillModel(model).addAttribute("personToEdit", patient)
                .addAttribute("requestType", "edit")
                .addAttribute("personType", "patient")
                .addAttribute("currentAddress", patientService.findById(patient.getId()).getPersonalInformation().getAddress());
        return "personEdit";
    }

    @GetMapping(value = {"/add/{doctor}", "/add"})
    public String editForm(@PathVariable(required = false) Doctor doctor, Model model) {
        controller.fillModel(model).addAttribute("currentAddress", new Address())
                .addAttribute("personToEdit", new Patient())
                .addAttribute("personType", "patient")
                .addAttribute("requestType", "add");
        if(doctor != null) model.addAttribute("doctor", doctor);
        return "personEdit";
    }

    @PostMapping("/update")
    public String update(PersonDTO patientDTO,
                         @RequestParam(value = "personId", required = false) Patient patient,
                         @RequestParam(value = "doctorId", required = false) Doctor doctor, Model model) {
        if(patient == null) {
            Patient newPatient = (Patient) controller.createPerson(patientDTO, new Patient());
            if(patientService.findByPhone(patientDTO.getPhone()) != null) {
                return fillModelForExistingPhone(newPatient, doctor, model);
            } else {
                if (doctor != null) {
                    newPatient.setDoctorSet(new HashSet<>());
                    newPatient.addDoctor(doctor);
                }
                patientService.save(newPatient);
            }
        } else {
            Patient edited = patientService.findById(patient.getId());
            if(patientService.findByPhone(patientDTO.getPhone()) != null && !edited.getPersonalInformation().getPhone().equals(patientDTO.getPhone())) {
                return fillModelForExistingPhone(edited, doctor, model);
            } else {
                patientService.save((Patient) controller.fillPerson(patientDTO, edited));
            }
        }
        return (doctor == null) ? "redirect:/patient" : ("redirect:/doctor/info/" + doctor.getId());
    }

    public String fillModelForExistingPhone(Patient patient, Doctor doctor, Model model) {
        controller.fillModel(model).addAttribute("personToEdit", patient)
                .addAttribute("currentAddress", patient.getPersonalInformation().getAddress())
                .addAttribute("personType", "patient")
                .addAttribute("requestType", "add")
                .addAttribute("phoneExists", true);
        if(doctor != null) model.addAttribute("doctor", doctor);
        return "personEdit";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("personId") Patient patient) {
        patientService.deleteById(patient.getId());
        return "redirect:/patient";
    }

    @GetMapping("/info/{patient}")
    public String info(@PathVariable Patient patient, Model model) {
        model.addAttribute("patient", patientService.findById(patient.getId()))
            .addAttribute("patientDoctors", patient.getDoctorSet().stream().filter(x -> !x.isDeleted()).iterator())
            .addAttribute("certificatesOfIllness", certificateOfIllnessService.findByPatientId(patient.getId()));
        return "patientInfo";
    }

    public Model find(String phone, Model model) {
        Patient byPhone = patientService.findByPhone(phone);
        if(byPhone == null) {
            model.addAttribute("patients", byPhone);
        } else {
            List<Patient> doctorList = new ArrayList<>();
            doctorList.add(byPhone);
            model.addAttribute("patients", doctorList);
        }
        model.addAttribute("currPhone", phone);
        return model;
    }
}