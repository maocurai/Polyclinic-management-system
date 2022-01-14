package com.example.springApp.service;

import com.example.springApp.domain.City;
import com.example.springApp.domain.Region;
import com.example.springApp.repos.RegionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private final RegionRepo regionRepo;

    public RegionService(RegionRepo regionRepo) {
        this.regionRepo = regionRepo;
    }

    public List<Region> findAll() { return regionRepo.findAll(); }

    public Region findById(Long id) { return regionRepo.findByid(id); }

    public Region save(Region region) { return regionRepo.save(region); }
}
