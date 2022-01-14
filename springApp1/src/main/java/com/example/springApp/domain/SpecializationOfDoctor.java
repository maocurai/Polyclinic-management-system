package com.example.springApp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "specialization_of_doctor")
public class SpecializationOfDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy="specializationOfDoctor")
    private Set<Doctor> doctorSet;

    public SpecializationOfDoctor() {}

    public SpecializationOfDoctor(String name, Set<Doctor> doctorSet) {
        this.name = name;
        this.doctorSet = doctorSet;
    }

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

    public Set<Doctor> getDoctorSet() {
        return doctorSet;
    }

    public void setDoctorSet(Set<Doctor> doctorSet) {
        this.doctorSet = doctorSet;
    }
}
