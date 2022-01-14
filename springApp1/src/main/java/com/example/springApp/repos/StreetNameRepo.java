package com.example.springApp.repos;

import com.example.springApp.domain.StreetName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetNameRepo extends JpaRepository<StreetName, Long> {
    List<StreetName> findAll();
    StreetName findByid(Long id);
}
