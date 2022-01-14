package com.example.springApp.repos;

import com.example.springApp.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepo extends JpaRepository<Region, Long> {
    List<Region> findAll();
    Region findByid(Long id);
}
