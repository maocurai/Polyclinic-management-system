package com.example.springApp.controller;

import com.example.springApp.DTO.Dto;
import com.example.springApp.DTO.PersonDTO;
import com.example.springApp.domain.Address;
import com.example.springApp.domain.Person;
import com.example.springApp.domain.PersonalInformation;
import com.example.springApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.time.LocalDate;

@Controller
public class UtilityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private StreetTypeService streetTypeService;

    @Autowired
    private StreetNameService streetNameService;

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private DiseaseTypeService diseaseTypeService;

    public Model fillModel(Model model) {
        return model.addAttribute("cities", cityService.findAll())
                .addAttribute("regions", regionService.findAll())
                .addAttribute("streetTypes", streetTypeService.findAll())
                .addAttribute("streetNames", streetNameService.findAll());
    }

    public Model fillStatisticsModel(Model model) {
        return model.addAttribute("diseaseTypes", diseaseTypeService.findAll())
                .addAttribute("diseases", diseaseService.findAllOrderByNameASC())
                .addAttribute("cities", cityService.findAll())
                .addAttribute("streetTypes", streetTypeService.findAll())
                .addAttribute("streetNames", streetNameService.findAll());
    }

    public Model fillDiseaseModel(Model model) {
        return model.addAttribute("diseaseTypes", diseaseTypeService.findAll())
                .addAttribute("diseases", diseaseService.findAllOrderByNameASC());
    }

    public Person createPerson(PersonDTO personDTO, Person person) {
        person.setFullName(personDTO.getFullName());
        person.setPersonalInformation(new PersonalInformation(personDTO.getPhone(), personDTO.getEmail(),
                LocalDate.parse(personDTO.getDateOfBirth()),
                createAddress(personDTO), false));
        person.setDeleted(false);
        return person;
    }

    public Address createAddress(Dto dto) {
        return new Address(cityService.findById(dto.getCityId()),
                regionService.findById(dto.getRegionId()),
                streetTypeService.findById(dto.getStreetTypeId()),
                streetNameService.findById(dto.getStreetNameId()),
                dto.getBuildingNumber());
    }

    public Person fillPerson(PersonDTO personDTO, Person person) {
        person.setFullName(personDTO.getFullName());
        PersonalInformation personalInformation = person.getPersonalInformation();
        Address address = personalInformation.getAddress();
        personalInformation.setAddress(fillAddress(personDTO, address));
        personalInformation.setEmail(personDTO.getEmail());
        personalInformation.setPhone(personDTO.getPhone());
        personalInformation.setDateOfBirth(LocalDate.parse(personDTO.getDateOfBirth()));
        person.setPersonalInformation(personalInformation);
        return person;
    }

    public Address fillAddress(Dto dto, Address address) {
        address.setCity(cityService.findById(dto.getCityId()));
        address.setRegion(regionService.findById(dto.getRegionId()));
        address.setStreetType(streetTypeService.findById(dto.getStreetTypeId()));
        address.setStreetName(streetNameService.findById(dto.getStreetNameId()));
        address.setBuildingNumber(dto.getBuildingNumber());
        return address;
    }
}
