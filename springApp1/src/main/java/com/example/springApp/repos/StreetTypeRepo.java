package com.example.springApp.repos;

import com.example.springApp.domain.StreetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetTypeRepo extends JpaRepository<StreetType, Long> {
    List<StreetType> findAll();
    StreetType findByid(Long id);
}