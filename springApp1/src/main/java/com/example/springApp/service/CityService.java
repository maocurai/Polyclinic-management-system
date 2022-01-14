package com.example.springApp.service;

import com.example.springApp.domain.City;
import com.example.springApp.repos.CityRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepo cityRepo;

    public CityService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public List<City> findAll() { return cityRepo.findAll(); }

    public City findById(Long id) { return cityRepo.findByid(id); }

    public City save(City city) { return cityRepo.save(city); }

    public List<City> findCitiesWithMedicalInstitutions() { return cityRepo.findCitiesWithMedicalInstitutions(); }
}
