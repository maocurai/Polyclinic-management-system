package com.example.springApp.service;

import com.example.springApp.domain.Address;
import com.example.springApp.repos.*;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepo addressRepo;

    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public Address findAddressById(Long id) { return addressRepo.findByid(id); }

    public Address save(Address address) { return addressRepo.save(address); }
}
