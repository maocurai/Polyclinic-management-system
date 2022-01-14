package com.example.springApp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable=true)
    private City city;

    @ManyToOne
    @JoinColumn(name="region_id", nullable=true)
    private Region region;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="street_type_id", nullable=true)
    private StreetType streetType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="street_name_id", nullable=true)
    private StreetName streetName;

    private String buildingNumber;

    @OneToMany(mappedBy="address")
    @JsonBackReference
    private Set<PersonalInformation> personalInformationSet;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private MedicalInstitution medicalInstitution;

    public Address() {}

    public Address(City city, Region region, StreetType streetType, StreetName streetName, String buildingNumber) {
        this.city = city;
        this.region = region;
        this.streetType = streetType;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public StreetType getStreetType() {
        return streetType;
    }

    public void setStreetType(StreetType streetType) {
        this.streetType = streetType;
    }

    public StreetName getStreetName() {
        return streetName;
    }

    public void setStreetName(StreetName streetName) {
        this.streetName = streetName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Set<PersonalInformation> getPersonalInformationSet() {
        return personalInformationSet;
    }

    public void setPersonalInformationSet(Set<PersonalInformation> personalInformationSet) {
        this.personalInformationSet = personalInformationSet;
    }
}
