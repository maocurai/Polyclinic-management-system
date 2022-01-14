package com.example.springApp.repos;

import com.example.springApp.domain.MedicalInstitution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalInstitutionRepo extends JpaRepository<MedicalInstitution, Long> {
    List<MedicalInstitution> findAll();
    MedicalInstitution findByid(Long id);
}
