package com.example.springApp.repos;

import com.example.springApp.domain.CertificateOfIllness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateOfIllnessRepo extends JpaRepository<CertificateOfIllness, Long> {
    List<CertificateOfIllness> findByPatientId(Long id);
    List<CertificateOfIllness> findByDoctorId(Long id);
}
