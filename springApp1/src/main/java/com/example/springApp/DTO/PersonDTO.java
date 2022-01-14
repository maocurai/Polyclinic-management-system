package com.example.springApp.DTO;

public class PersonDTO implements Dto {
    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private String dateOfBirth;
    private Long cityId;
    private Long regionId;
    private Long streetTypeId;
    private Long streetNameId;
    private String buildingNumber;
    private Long specializationOfDoctorId;
    private Long medicalInstitutionId;

    public PersonDTO(String fullName, String phone, String email, String dateOfBirth,
                     Long cityId, Long regionId, Long streetTypeId, Long streetNameId,
                     String buildingNumber, Long specializationOfDoctorId, Long medicalInstitutionId) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.cityId = cityId;
        this.regionId = regionId;
        this.streetTypeId = streetTypeId;
        this.streetNameId = streetNameId;
        this.buildingNumber = buildingNumber;
        this.specializationOfDoctorId = specializationOfDoctorId;
        this.medicalInstitutionId = medicalInstitutionId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getStreetTypeId() {
        return streetTypeId;
    }

    public void setStreetTypeId(Long streetTypeId) {
        this.streetTypeId = streetTypeId;
    }

    public Long getStreetNameId() {
        return streetNameId;
    }

    public void setStreetNameId(Long streetNameId) {
        this.streetNameId = streetNameId;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Long getSpecializationOfDoctorId() { return specializationOfDoctorId; }

    public void setSpecializationOfDoctorId(Long specializationOfDoctorId) { this.specializationOfDoctorId = specializationOfDoctorId; }

    public Long getMedicalInstitutionId() {
        return medicalInstitutionId;
    }

    public void setMedicalInstitutionId(Long medicalInstitutionId) {
        this.medicalInstitutionId = medicalInstitutionId;
    }
}
