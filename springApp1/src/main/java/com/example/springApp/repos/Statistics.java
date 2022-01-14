package com.example.springApp.repos;

import org.springframework.stereotype.Repository;

@Repository
public interface Statistics {
    Integer getPatientsCount();
    String getRegionName();
    String getName();
    String getDiseaseName();
    Integer getYears();
}
