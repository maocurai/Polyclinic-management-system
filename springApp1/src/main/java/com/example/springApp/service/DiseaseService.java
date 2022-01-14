package com.example.springApp.service;

import com.example.springApp.domain.Disease;
import com.example.springApp.repos.DiseaseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {
    private final DiseaseRepo diseaseRepo;

    public DiseaseService(DiseaseRepo diseaseRepo) {
        this.diseaseRepo = diseaseRepo;
    }

    public List<Disease> findAll() { return diseaseRepo.findAll(); }

    public Disease findById(Long id) { return diseaseRepo.findByid(id); }

    public List<Disease> findAllOrderByNameASC() { return diseaseRepo.findAllByOrderByNameAsc(); }

    public Disease findByName(String name) { return  diseaseRepo.findByName(name); }

    public void save(Disease disease) {
        diseaseRepo.save(disease);
    }
}
