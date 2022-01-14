package com.example.springApp.service;

import com.example.springApp.domain.MedicalInstitution;
import com.example.springApp.domain.Patient;
import com.example.springApp.repos.AddressRepo;
import com.example.springApp.repos.DoctorRepo;
import com.example.springApp.repos.MedicalInstitutionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class MedicalInstitutionService {

    private final MedicalInstitutionRepo medicalInstitutionRepo;
    private final AddressRepo addressRepo;
    private final DoctorRepo doctorRepo;

    public MedicalInstitutionService(MedicalInstitutionRepo medicalInstitutionRepo, AddressRepo addressRepo, DoctorRepo doctorRepo) {
        this.medicalInstitutionRepo = medicalInstitutionRepo;
        this.addressRepo = addressRepo;
        this.doctorRepo = doctorRepo;
    }

    public MedicalInstitution findById(Long id) { return  medicalInstitutionRepo.findByid(id); }

    public List<MedicalInstitution> findAll() {
        return medicalInstitutionRepo.findAll();
    }

    public MedicalInstitution update(MedicalInstitution medicalInstitution) {
        return medicalInstitutionRepo.save(medicalInstitution);
    }

    public MedicalInstitution deleteById(Long id) {
        MedicalInstitution medicalInstitution = medicalInstitutionRepo.findByid(id);
        medicalInstitution.setDeleted(true);
        return medicalInstitutionRepo.save(medicalInstitution);
    }

    @Transactional
    public MedicalInstitution save(MedicalInstitution medicalInstitution) {
        addressRepo.save(medicalInstitution.getAddress());
        return medicalInstitutionRepo.save(medicalInstitution);
    }


}
