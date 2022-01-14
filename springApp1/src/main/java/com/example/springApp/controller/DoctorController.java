package com.example.springApp.controller;

import com.example.springApp.DTO.PersonDTO;
import com.example.springApp.domain.*;
import com.example.springApp.service.CertificateOfIllnessService;
import com.example.springApp.service.DoctorService;
import com.example.springApp.service.MedicalInstitutionService;
import com.example.springApp.service.SpecializationOfDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private  SpecializationOfDoctorService specializationOfDoctorService;

    @Autowired
    private MedicalInstitutionService medicalInstitutionService;

    @Autowired
    private UtilityController controller;

    @Autowired
    private CertificateOfIllnessService certificateOfIllnessService;


    @GetMapping
    public String list(@RequestParam(value = "phone", required = false) String phone, Model model) {
        if(phone != null) {
            find(phone, model);
        } else {
            model.addAttribute("doctors", doctorService.findAll().stream().filter(x -> !x.isDeleted()).iterator());
        }
        return "doctor";
    }

    public String find(String phone, Model model) {
        Doctor byPhone = doctorService.findByPhone(phone);
        if(byPhone == null) {
            model.addAttribute("doctors", byPhone);
        } else {
            List<Doctor> doctorList = new ArrayList<>();
            doctorList.add(byPhone);
            model.addAttribute("doctors", doctorList);
        }
        model.addAttribute("currPhone", phone);
        return "doctor";
    }

    @GetMapping("{doctor}")
    public String editForm(@PathVariable Doctor doctor, Model model) {
        controller.fillModel(model).addAttribute("personToEdit", doctor)
                .addAttribute("specialisations", specializationOfDoctorService.findAll())
                .addAttribute("medicalInstitutions", medicalInstitutionService.findAll())
                .addAttribute("requestType", "edit")
                .addAttribute("personType", "doctor")
                .addAttribute("currentAddress", doctorService.findById(doctor.getId()).getPersonalInformation().getAddress());
        return "personEdit";
    }

    @GetMapping("/add")
    public String editForm(Model model) {
        controller.fillModel(model).addAttribute("currentAddress", new Address())
                .addAttribute("personToEdit", new Doctor())
                .addAttribute("specialisations", specializationOfDoctorService.findAll())
                .addAttribute("medicalInstitutions", medicalInstitutionService.findAll())
                .addAttribute("requestType", "add")
                .addAttribute("personType", "doctor");
        return "personEdit";
    }

    @PostMapping("/update")
    public String update(PersonDTO patientDTO, @RequestParam(value = "personId", required = false) Doctor doctor, Model model) {
        if(doctor == null) {
            Doctor newDoctor = fillDoctor(patientDTO, (Doctor) controller.createPerson(patientDTO, new Doctor()));
            if(doctorService.findByPhone(patientDTO.getPhone()) != null) {
                return fillModelForExistingPhone(newDoctor, model);
            } else {
                doctorService.save(newDoctor);
            }
        } else {
            Doctor edited = doctorService.findById(doctor.getId());
            if(doctorService.findByPhone(patientDTO.getPhone()) != null  && !edited.getPersonalInformation().getPhone().equals(patientDTO.getPhone())) {
                return fillModelForExistingPhone(doctor, model);
            } else {
                doctorService.save(fillDoctor(patientDTO, (Doctor) controller.fillPerson(patientDTO, edited)));
            }
        }
        return "redirect:/doctor";
    }

    public String fillModelForExistingPhone(Doctor doctor, Model model) {
        controller.fillModel(model).addAttribute("personToEdit", doctor)
                .addAttribute("specialisations", specializationOfDoctorService.findAll())
                .addAttribute("medicalInstitutions", medicalInstitutionService.findAll())
                .addAttribute("requestType", "edit")
                .addAttribute("personType", "doctor")
                .addAttribute("phoneExists", true)
                .addAttribute("currentAddress", doctor.getPersonalInformation().getAddress());
        return "personEdit";
    }

    public Doctor fillDoctor(PersonDTO personDTO, Doctor doctor) {
        doctor.setSpecializationOfDoctor(specializationOfDoctorService.findById(personDTO.getSpecializationOfDoctorId()));
        doctor.setMedicalInstitution(medicalInstitutionService.findById(personDTO.getMedicalInstitutionId()));
        return doctor;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("personId") Doctor doctor) {
        doctorService.deleteById(doctor.getId());
        return "redirect:/doctor";
    }

    @GetMapping("/addCertificateOfIllness/{doctor}")
    public String addFormCertificateOfIllness(@PathVariable Doctor doctor, Model model) {
        controller.fillStatisticsModel(model);
        model.addAttribute("doctor", doctor);
        return "addCertificateOfIllness";
    }

    @GetMapping( "/editCertificateOfIllness/{certificateOfIllness}")
    public String editFormCertificateOfIllness(@PathVariable CertificateOfIllness certificateOfIllness, Model model) {
        controller.fillStatisticsModel(model);
        model.addAttribute("currCertificateOfIllness", certificateOfIllness);
        return "editCertificateOfIllness";
    }

    @PostMapping( "/saveCertificateOfIllness")
    public String addCertificateOfIllness(@RequestParam("certificateId") CertificateOfIllness certificateOfIllness,
                                          @RequestParam("diseaseId") Disease disease,
                                          @RequestParam("date") String date) {
        certificateOfIllness.setDisease(disease);
        certificateOfIllness.setDateOfBirth(LocalDate.parse(date));
        certificateOfIllnessService.save(certificateOfIllness);
        return ("redirect:/patient/info/" + certificateOfIllness.getPatient().getId());
    }

    @PostMapping("/certificateOfIllness/update")
    public String updateCertificateOfIllness(@RequestParam("doctorId") Doctor doctor,
                                          @RequestParam("patientId") Patient patient,
                                          @RequestParam("diseaseId") Disease disease,
                                          @RequestParam("date") String date, Model model
                                          ) {
        certificateOfIllnessService.save(new CertificateOfIllness(patient, doctor, doctor.getMedicalInstitution(), LocalDate.parse(date), disease));
        return "redirect:/doctor";
    }

    @GetMapping("/info/{doctor}")
    public String info(@PathVariable Doctor doctor, Model model) {
        model.addAttribute("patient", doctorService.findById(doctor.getId()))
                .addAttribute("patientDoctors", doctor.getPatientSet().stream().filter(x -> !x.isDeleted()).iterator())
                .addAttribute("certificatesOfIllness", certificateOfIllnessService.findByDoctorId(doctor.getId()))
                .addAttribute("doctor", doctor);
        return "doctorInfo";
    }
}
