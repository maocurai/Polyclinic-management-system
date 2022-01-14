package com.example.springApp.service;

import com.example.springApp.domain.Region;
import com.example.springApp.domain.SpecializationOfDoctor;
import com.example.springApp.repos.RegionRepo;
import com.example.springApp.repos.SpecializationOfDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationOfDoctorService {

    @Autowired
    private final SpecializationOfDoctorRepo specializationOfDoctorRepo;

    public SpecializationOfDoctorService(SpecializationOfDoctorRepo specializationOfDoctorRepo) {
        this.specializationOfDoctorRepo = specializationOfDoctorRepo;
    }

    public List<SpecializationOfDoctor> findAll() { return specializationOfDoctorRepo.findAll(); }

    public SpecializationOfDoctor findById(Long id) { return specializationOfDoctorRepo.findByid(id); }

    public SpecializationOfDoctor save(SpecializationOfDoctor specializationOfDoctor) { return specializationOfDoctorRepo.save(specializationOfDoctor); }
}
