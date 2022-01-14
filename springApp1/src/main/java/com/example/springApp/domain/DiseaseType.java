package com.example.springApp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "disease_type")
public class DiseaseType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy="diseaseType")
    @JsonBackReference
    private Set<Disease> diseaseSet;

    public DiseaseType() {}

    public DiseaseType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DiseaseType(String name) {
        this.name = name;
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

    public Set<Disease> getDiseaseSet() {
        return diseaseSet;
    }

    public void setDiseaseSet(Set<Disease> diseaseSet) {
        this.diseaseSet = diseaseSet;
    }
}
