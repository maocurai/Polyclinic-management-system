package com.example.springApp.domain;

public interface Person {
    Long getId();
    void setId(Long id);
    String getFullName();
    void setFullName(String fullName);
    boolean isDeleted();
    void setDeleted(boolean deleted);
    PersonalInformation getPersonalInformation();
    void setPersonalInformation(PersonalInformation personalInformation);
}
