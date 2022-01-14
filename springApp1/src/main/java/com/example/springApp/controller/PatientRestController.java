package com.example.springApp.controller;

import com.example.springApp.domain.Patient;
import com.example.springApp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patientRest")
public class PatientRestController {

    @Autowired
    private PatientService patientService;


    @GetMapping
    public Iterable<Patient> userList() {
        return patientService.findAll();
    }

    @PostMapping("/add")
    public Patient add(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @PutMapping(value = "/update/{id}/{newName}")
    public Patient update(
            @PathVariable("newName") String patientname,
            @PathVariable("id") Long id) {
        Patient edited = patientService.findById(id);
        edited.setFullName(patientname);
        patientService.update(edited);
        return edited;
    }

    @DeleteMapping(value = "/{id}")
    public Patient delete(@PathVariable("id") Long id) {
        patientService.deleteById(id);
        System.out.println(patientService.findById(id));
        return patientService.findById(id);
    }
}
