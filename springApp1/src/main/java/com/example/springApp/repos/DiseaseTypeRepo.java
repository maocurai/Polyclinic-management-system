package com.example.springApp.repos;

import com.example.springApp.domain.DiseaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseTypeRepo extends JpaRepository<DiseaseType, Long> {
    List<DiseaseType> findAllByOrderByIdAsc();

    DiseaseType findByName(String diseaseTypeName);
}
