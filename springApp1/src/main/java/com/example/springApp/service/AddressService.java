package com.example.springApp.service;

import com.example.springApp.DTO.Dto;
import com.example.springApp.domain.Address;
import com.example.springApp.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepo addressRepo;
    private final CityService cityService;
    private final RegionService regionService;
    private final StreetTypeService streetTypeService;
    private final StreetNameService streetNameService;
    private final DiseaseService diseaseService;
    private final DiseaseTypeService diseaseTypeService;

    public AddressService(AddressRepo addressRepo, CityService cityService, RegionService regionService,
                          StreetTypeService streetTypeService, StreetNameService streetNameService,
                          DiseaseService diseaseService, DiseaseTypeService diseaseTypeService) {
        this.addressRepo = addressRepo;
        this.cityService = cityService;
        this.regionService = regionService;
        this.streetTypeService = streetTypeService;
        this.streetNameService = streetNameService;
        this.diseaseService = diseaseService;
        this.diseaseTypeService = diseaseTypeService;
    }

    public Address findAddressById(Long id) { return addressRepo.findByid(id); }

    public Address save(Address address) { return addressRepo.save(address); }

    public Address fill(Dto dto, Address address) {
        address.setCity(cityService.findById(dto.getCityId()));
        address.setRegion(regionService.findById(dto.getRegionId()));
        address.setStreetType(streetTypeService.findById(dto.getStreetTypeId()));
        address.setStreetName(streetNameService.findById(dto.getStreetNameId()));
        address.setBuildingNumber(dto.getBuildingNumber());
        return address;
    }

    public Address create(Dto dto) {
        return new Address(cityService.findById(dto.getCityId()),
                regionService.findById(dto.getRegionId()),
                streetTypeService.findById(dto.getStreetTypeId()),
                streetNameService.findById(dto.getStreetNameId()),
                dto.getBuildingNumber());
    }
}
