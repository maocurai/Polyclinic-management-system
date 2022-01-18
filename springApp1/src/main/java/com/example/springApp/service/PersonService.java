package com.example.springApp.service;

import com.example.springApp.DTO.PersonDTO;
import com.example.springApp.domain.Address;
import com.example.springApp.domain.Doctor;
import com.example.springApp.domain.Person;
import com.example.springApp.domain.PersonalInformation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PersonService {

    private final AddressService addressService;

    public PersonService(AddressService addressService) {
        this.addressService = addressService;
    }

    public Person fillPerson(PersonDTO personDTO, Person person) {
        person.setFullName(personDTO.getFullName());
        PersonalInformation personalInformation = person.getPersonalInformation();
        Address address = personalInformation.getAddress();
        personalInformation.setAddress(addressService.fill(personDTO, address));
        personalInformation.setEmail(personDTO.getEmail());
        personalInformation.setPhone(personDTO.getPhone());
        personalInformation.setDateOfBirth(LocalDate.parse(personDTO.getDateOfBirth()));
        person.setPersonalInformation(personalInformation);
        return person;
    }

    public Person create(PersonDTO personDTO, Person person) {
        person.setFullName(personDTO.getFullName());
        person.setPersonalInformation(new PersonalInformation(personDTO.getPhone(), personDTO.getEmail(),
                LocalDate.parse(personDTO.getDateOfBirth()),
                addressService.create(personDTO), false));
        person.setDeleted(false);
        return person;
    }
}
