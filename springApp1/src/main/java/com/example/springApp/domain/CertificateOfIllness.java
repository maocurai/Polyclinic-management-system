package com.example.springApp.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "certificate_of_illness")
public class CertificateOfIllness {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="patient_id", nullable=false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="doctor_id", nullable=false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="medical_institution_id", nullable=true)
    private MedicalInstitution medicalInstitution;

    @Column(name = "date", columnDefinition = "DATE")
    private LocalDate dateOfBirth;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="disease_id", nullable=false)
    private Disease disease;

    public CertificateOfIllness() {}

    public CertificateOfIllness(Patient patient, Doctor doctor, MedicalInstitution medicalInstitution, LocalDate dateOfBirth, Disease disease) {
        this.patient = patient;
        this.doctor = doctor;
        this.medicalInstitution = medicalInstitution;
        this.dateOfBirth = dateOfBirth;
        this.disease = disease;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public MedicalInstitution getMedicalInstitution() {
        return medicalInstitution;
    }

    public void setMedicalInstitution(MedicalInstitution medicalInstitution) {
        this.medicalInstitution = medicalInstitution;
    }
}
