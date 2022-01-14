package com.example.springApp.repos;


import com.example.springApp.domain.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalInformationRepo extends JpaRepository<PersonalInformation, Long> {
    List<PersonalInformation> findAll();
    PersonalInformation findByid(Long id);
}
