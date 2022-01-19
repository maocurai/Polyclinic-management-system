package com.example.springApp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor implements Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String fullName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_info_id", referencedColumnName = "id", nullable=true)
    private PersonalInformation personalInformation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="specialization_id", nullable=true)
    private SpecializationOfDoctor specializationOfDoctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="medical_institution_id", nullable=true)
    private MedicalInstitution medicalInstitution;

    private boolean deleted;

    @OneToMany(mappedBy="doctor")
    @JsonBackReference
    private Set<CertificateOfIllness> certificateOfIllnessSet;

    @ManyToMany
    @JoinTable(
            name = "patient_doctor",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id"))
    private Set<Patient> patientSet;

    public Doctor() {}

    public Doctor(String fullName, PersonalInformation personalInformation,
                  SpecializationOfDoctor specializationOfDoctor, MedicalInstitution medicalInstitution, boolean deleted) {
        this.fullName = fullName;
        this.personalInformation = personalInformation;
        this.specializationOfDoctor = specializationOfDoctor;
        this.medicalInstitution = medicalInstitution;
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

    public SpecializationOfDoctor getSpecializationOfDoctor() {
        return specializationOfDoctor;
    }

    public void setSpecializationOfDoctor(SpecializationOfDoctor specializationOfDoctor) {
        this.specializationOfDoctor = specializationOfDoctor;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public MedicalInstitution getMedicalInstitution() {
        return medicalInstitution;
    }

    public void setMedicalInstitution(MedicalInstitution medicalInstitution) {
        this.medicalInstitution = medicalInstitution;
    }

    public Set<CertificateOfIllness> getCertificateOfIllnessSet() {
        return certificateOfIllnessSet;
    }

    public void setCertificateOfIllnessSet(Set<CertificateOfIllness> certificateOfIllnessSet) {
        this.certificateOfIllnessSet = certificateOfIllnessSet;
    }

    public Set<Patient> getPatientSet() {
        return patientSet;
    }

    public void setPatientSet(Set<Patient> patientSet) {
        this.patientSet = patientSet;
    }

    public void addPatient(Patient patient) {
        patientSet.add(patient);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", personalInformation=" + personalInformation +
                ", specializationOfDoctor=" + specializationOfDoctor +
                ", medicalInstitution=" + medicalInstitution +
                '}';
    }
}
