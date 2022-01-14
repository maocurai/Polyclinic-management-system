package com.example.springApp.service;

import com.example.springApp.domain.City;
import com.example.springApp.domain.StreetType;
import com.example.springApp.repos.StreetTypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetTypeService {

    private final StreetTypeRepo streetTypeRepo;

    public StreetTypeService(StreetTypeRepo streetTypeRepo) {
        this.streetTypeRepo = streetTypeRepo;
    }

    public List<StreetType> findAll() { return streetTypeRepo.findAll(); }

    public StreetType findById(Long id) { return streetTypeRepo.findByid(id); }

    public StreetType save(StreetType streetType) { return streetTypeRepo.save(streetType); }
}
