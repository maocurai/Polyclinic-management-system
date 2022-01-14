package com.example.springApp.service;

import com.example.springApp.domain.Doctor;
import com.example.springApp.domain.Patient;
import com.example.springApp.domain.PersonalInformation;
import com.example.springApp.repos.AddressRepo;
import com.example.springApp.repos.PatientRepo;
import com.example.springApp.repos.PersonalInformationRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PatientService {

    private final PatientRepo patientRepo;
    private final AddressRepo addressRepo;
    private final PersonalInformationRepo personalInformationRepo;


    public PatientService(PatientRepo patientRepo, AddressRepo addressRepo, PersonalInformationRepo personalInformationRepo) {
        this.patientRepo = patientRepo;
        this.addressRepo = addressRepo;
        this.personalInformationRepo = personalInformationRepo;
    }

    public Patient findById(Long id) { return  patientRepo.findByid(id); }

    public List<Patient> findAll() {
        return patientRepo.findAll();
    }

    public Patient update(Patient patient) {
        return patientRepo.save(patient);
    }

    @Transactional
    public Patient deleteById(Long id) {
        Patient patient = patientRepo.findByid(id);
        PersonalInformation personalInformation = patient.getPersonalInformation();
        personalInformation.setDeleted(true);
        personalInformation.setPhone(null);
        personalInformationRepo.save(personalInformation);
        patient.setDeleted(true);
        return patientRepo.save(patient);
    }

    @Transactional
    public Patient save(Patient patient) {
        addressRepo.save(patient.getPersonalInformation().getAddress());
        personalInformationRepo.save(patient.getPersonalInformation());
        return patientRepo.save(patient);
    }

    public List<Patient> findByMedicalInstitution(Long id) { return patientRepo.findByMedicalInstitutionId(id); }

    @Transactional
    public Patient findByPhone(String phone) {
        return patientRepo.findByPhone(phone);
    }

    public Patient addDoctor(Patient patient, Doctor doctor) {
        Set<Doctor> doctorSet = patient.getDoctorSet();
        if(doctorSet != null) {
            doctorSet.add(doctor);
        } else {
            patient.setDoctorSet(new HashSet<>());
            patient.addDoctor(doctor);
        }
        patientRepo.save(patient);
        return patient;
    }
}
