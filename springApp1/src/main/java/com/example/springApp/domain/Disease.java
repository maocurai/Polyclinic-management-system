package com.example.springApp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "disease")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="disease_type_id", nullable=false)
    private DiseaseType diseaseType;

    @OneToMany(mappedBy="disease")
    @JsonBackReference
    private Set<CertificateOfIllness> certificateOfIllnessSet;

    public Disease() {}

    public Disease(Long id, String name, DiseaseType diseaseType) {
        this.id = id;
        this.name = name;
        this.diseaseType = diseaseType;
    }

    public Disease(String name, DiseaseType diseaseType) {
        this.name = name;
        this.diseaseType = diseaseType;
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

    public DiseaseType getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(DiseaseType diseaseType) {
        this.diseaseType = diseaseType;
    }

    public Set<CertificateOfIllness> getCertificateOfIllnessSet() {
        return certificateOfIllnessSet;
    }

    public void setCertificateOfIllnessSet(Set<CertificateOfIllness> certificateOfIllnessSet) {
        this.certificateOfIllnessSet = certificateOfIllnessSet;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", diseaseType=" + diseaseType +
                ", certificateOfIllnessSet=" + certificateOfIllnessSet +
                '}';
    }
}
