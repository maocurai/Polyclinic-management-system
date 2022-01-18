package com.example.springApp.service;

import com.example.springApp.DTO.PersonDTO;
import com.example.springApp.domain.Doctor;
import com.example.springApp.domain.Patient;
import com.example.springApp.domain.PersonalInformation;
import com.example.springApp.repos.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DoctorService {

    private final DoctorRepo doctorRepo;
    private final AddressRepo addressRepo;
    private final PersonalInformationRepo personalInformationRepo;
    private final MedicalInstitutionRepo medicalInstitutionRepo;
    private final SpecializationOfDoctorRepo specializationOfDoctorRepo;
    private final PersonService personService;

    public DoctorService(DoctorRepo doctorRepo, AddressRepo addressRepo, PersonalInformationRepo personalInformationRepo,
                         MedicalInstitutionRepo medicalInstitutionRepo, SpecializationOfDoctorRepo specializationOfDoctorRepo,
                         PersonService personService) {
        this.doctorRepo = doctorRepo;
        this.addressRepo = addressRepo;
        this.personalInformationRepo = personalInformationRepo;
        this.medicalInstitutionRepo = medicalInstitutionRepo;
        this.specializationOfDoctorRepo = specializationOfDoctorRepo;
        this.personService = personService;
    }

    public Doctor findById(Long id) { return  doctorRepo.findByid(id); }

    public List<Doctor> findAll() {
        return doctorRepo.findAll();
    }

    public Doctor update(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    public Optional update(Doctor doctor, PersonDTO personDTO) {
        if(doctor == null) {
            Doctor newDoctor = fillDoctor(personDTO, (Doctor)personService.create(personDTO, new Doctor()));
            if(findByPhone(personDTO.getPhone()) != null) {
                return Optional.of(newDoctor);
            } else {
                save(newDoctor);
            }
        } else {
            Doctor edited = findById(doctor.getId());
            if(findByPhone(personDTO.getPhone()) != null  && !edited.getPersonalInformation().getPhone().equals(personDTO.getPhone())) {
                return Optional.of(doctor);
            } else {
                save(fillDoctor(personDTO, (Doctor)personService.fillPerson(personDTO, edited)));
            }
        }
        return Optional.empty();
    }

    public Doctor deleteById(Long id) {
        Doctor doctor = doctorRepo.findByid(id);
        doctor.setDeleted(true);
        PersonalInformation personalInformation = doctor.getPersonalInformation();
        personalInformation.setDeleted(true);
        personalInformation.setPhone(null);
        return doctorRepo.save(doctor);
    }

    @Transactional
    public Doctor save(Doctor doctor) {
        addressRepo.save(doctor.getPersonalInformation().getAddress());
        personalInformationRepo.save(doctor.getPersonalInformation());
        medicalInstitutionRepo.save(doctor.getMedicalInstitution());
        specializationOfDoctorRepo.save(doctor.getSpecializationOfDoctor());
        return doctorRepo.save(doctor);
    }

    public Doctor findByPhone(String phone) {
        return doctorRepo.findByPhone(phone);
    }

    public Doctor addPatient(Doctor doctor, Patient patient) {
        Set<Patient> patientSet = doctor.getPatientSet();
        if(patientSet != null) {
            patientSet.add(patient);
        } else {
            doctor.setPatientSet(new HashSet<>());
            doctor.addPatient(patient);
        }
        doctorRepo.save(doctor);
        return doctor;
    }

    public Doctor fillDoctor(PersonDTO personDTO, Doctor doctor) {
        doctor.setSpecializationOfDoctor(specializationOfDoctorRepo.findByid(personDTO.getSpecializationOfDoctorId()));
        doctor.setMedicalInstitution(medicalInstitutionRepo.findByid(personDTO.getMedicalInstitutionId()));
        return doctor;
    }
}
