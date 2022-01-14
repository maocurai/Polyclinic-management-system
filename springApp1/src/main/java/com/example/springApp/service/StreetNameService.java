package com.example.springApp.service;

import com.example.springApp.domain.Region;
import com.example.springApp.domain.StreetName;
import com.example.springApp.repos.StreetNameRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetNameService {

    private final StreetNameRepo streetNameRepo;

    public StreetNameService(StreetNameRepo streetNameRepo) {
        this.streetNameRepo = streetNameRepo;
    }

    public List<StreetName> findAll() { return streetNameRepo.findAll(); }

    public StreetName findById(Long id) { return streetNameRepo.findByid(id); }

    public StreetName save(StreetName streetName) { return streetNameRepo.save(streetName); }
}
