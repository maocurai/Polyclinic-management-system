package com.example.springApp.repos;

import com.example.springApp.domain.Doctor;
import com.example.springApp.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    List<Patient> findAll();
    Patient findByid(Long id);
    @Query(
            value = "SELECT DISTINCT patient.id, patient.full_name, patient.personal_info_id, patient.deleted\n" +
            "FROM doctor INNER JOIN patient_doctor\n" +
            "ON doctor.id = patient_doctor.doctor_id\n" +
            "INNER JOIN patient \n" +
            "ON patient.id = patient_doctor.patient_id\n" +
            "WHERE `medical_institution_id` = ?1",
            nativeQuery = true
    )
    List<Patient> findByMedicalInstitutionId(Long id);

    @Query(
           value = "SELECT patient.id, patient.full_name, patient.personal_info_id, patient.deleted\n" +
                   "FROM patient INNER JOIN personal_information\n" +
                   "ON patient.personal_info_id = personal_information.id\n" +
                   "WHERE personal_information.phone = ?1",
            nativeQuery = true
    )
    Patient findByPhone(String phone);
}
