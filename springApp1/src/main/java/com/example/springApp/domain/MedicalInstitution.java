package com.example.springApp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "medical_institution")
public class MedicalInstitution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="address_id", nullable=true)
    private Address address;

    private boolean deleted;

    @OneToMany(mappedBy="medicalInstitution")
    @JsonBackReference
    private Set<Doctor> doctorSet;

    @OneToMany(mappedBy="medicalInstitution")
    @JsonBackReference
    private Set<CertificateOfIllness> certificateOfIllnessSet;

    public MedicalInstitution(String name, Address address, boolean deleted) {
        this.name = name;
        this.address = address;
        this.deleted = deleted;
    }

    public MedicalInstitution() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Set<Doctor> getDoctorSet() {
        return doctorSet;
    }

    public void setDoctorSet(Set<Doctor> doctorSet) {
        this.doctorSet = doctorSet;
    }
}
