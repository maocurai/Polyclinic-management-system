package com.example.springApp.repos;

import com.example.springApp.domain.Disease;
import com.example.springApp.domain.DiseaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseRepo extends JpaRepository<Disease, Long> {
    List<Disease> findAllByOrderByNameAsc();
    Disease findByid(Long id);
    Disease findByName(String name);
}
