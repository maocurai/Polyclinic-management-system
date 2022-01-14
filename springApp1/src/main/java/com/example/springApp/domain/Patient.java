package com.example.springApp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient implements Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String fullName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_info_id", referencedColumnName = "id", nullable=true)
    private PersonalInformation personalInformation;

    private boolean deleted;

    @OneToMany(mappedBy="patient")
    @JsonBackReference
    private Set<CertificateOfIllness> certificateOfIllnessSet;

    @ManyToMany
    @JoinTable(
            name = "patient_doctor",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    private Set<Doctor> doctorSet;

    public Patient() {}

    public Patient(String fullName, PersonalInformation personalInformation, boolean deleted) {
        this.fullName = fullName;
        this.personalInformation = personalInformation;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Set<CertificateOfIllness> getCertificateOfIllnessSet() {
        return certificateOfIllnessSet;
    }

    public void setCertificateOfIllnessSet(Set<CertificateOfIllness> certificateOfIllnessSet) {
        this.certificateOfIllnessSet = certificateOfIllnessSet;
    }

    public Set<Doctor> getDoctorSet() {
        return doctorSet;
    }

    public void setDoctorSet(Set<Doctor> doctorSet) {
        this.doctorSet = doctorSet;
    }

    public void addDoctor(Doctor doctor) {
        doctorSet.add(doctor);
    }
}
