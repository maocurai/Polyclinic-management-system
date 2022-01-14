package com.example.springApp.repos;

import com.example.springApp.domain.Doctor;
import com.example.springApp.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    List<Doctor> findAll();
    Doctor findByid(Long id);

    @Query(
            value = "SELECT doctor.id, doctor.full_name, doctor.medical_institution_id, doctor.personal_info_id, doctor.deleted, doctor.specialization_id \n" +
                    "FROM doctor INNER JOIN personal_information\n" +
                    "ON doctor.personal_info_id = personal_information.id\n" +
                    "WHERE personal_information.phone = ?1",
            nativeQuery = true
    )
    Doctor findByPhone(String phone);
}
