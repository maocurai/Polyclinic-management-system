package com.example.springApp.DTO;

public class MedicalInstitutionDTO implements Dto {
    private Long id;
    private String name;
    private Long cityId;
    private Long regionId;
    private Long streetTypeId;
    private Long streetNameId;
    private String buildingNumber;
    private Long specializationOfDoctorId;
    private Long medicalInstitutionId;

    public MedicalInstitutionDTO(String name, Long cityId, Long regionId, Long streetTypeId,
                                 Long streetNameId, String buildingNumber, Long specializationOfDoctorId,
                                 Long medicalInstitutionId) {
        this.name = name;
        this.cityId = cityId;
        this.regionId = regionId;
        this.streetTypeId = streetTypeId;
        this.streetNameId = streetNameId;
        this.buildingNumber = buildingNumber;
        this.specializationOfDoctorId = specializationOfDoctorId;
        this.medicalInstitutionId = medicalInstitutionId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getCityId() {
        return cityId;
    }

    @Override
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public Long getRegionId() {
        return regionId;
    }

    @Override
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    @Override
    public Long getStreetTypeId() {
        return streetTypeId;
    }

    @Override
    public void setStreetTypeId(Long streetTypeId) {
        this.streetTypeId = streetTypeId;
    }

    @Override
    public Long getStreetNameId() {
        return streetNameId;
    }

    @Override
    public void setStreetNameId(Long streetNameId) {
        this.streetNameId = streetNameId;
    }

    @Override
    public String getBuildingNumber() {
        return buildingNumber;
    }

    @Override
    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }
}
