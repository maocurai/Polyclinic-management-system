package com.example.springApp.repos;

import com.example.springApp.domain.SpecializationOfDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecializationOfDoctorRepo extends JpaRepository<SpecializationOfDoctor, Long> {
    List<SpecializationOfDoctor> findAll();
    SpecializationOfDoctor findByid(Long id);
}
