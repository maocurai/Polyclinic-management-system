package com.example.springApp.service;

import com.example.springApp.domain.DiseaseType;
import com.example.springApp.repos.DiseaseTypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseTypeService {
    private final DiseaseTypeRepo diseaseTypeRepo;

    public DiseaseTypeService(DiseaseTypeRepo diseaseTypeRepo) {
        this.diseaseTypeRepo = diseaseTypeRepo;
    }

    public List<DiseaseType> findAll() { return diseaseTypeRepo.findAll(); }

    public DiseaseType findByName(String diseaseTypeName) {
        return diseaseTypeRepo.findByName(diseaseTypeName);
    }

    public void save(DiseaseType diseaseType) {
        diseaseTypeRepo.save(diseaseType);
    }
}
