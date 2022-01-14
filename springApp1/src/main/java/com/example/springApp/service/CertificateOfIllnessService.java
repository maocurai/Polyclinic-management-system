package com.example.springApp.service;

import com.example.springApp.domain.CertificateOfIllness;
import com.example.springApp.repos.CertificateOfIllnessRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class CertificateOfIllnessService {

    private final CertificateOfIllnessRepo certificateOfIllnessRepo;

    public CertificateOfIllnessService(CertificateOfIllnessRepo certificateOfIllnessRepo) {
        this.certificateOfIllnessRepo = certificateOfIllnessRepo;
    }

    @Transactional
    public CertificateOfIllness save(CertificateOfIllness certificateOfIllness) {
        return certificateOfIllnessRepo.save(certificateOfIllness);
    }

    public List<CertificateOfIllness> findByDoctorId(Long id)  {
        return certificateOfIllnessRepo.findByDoctorId(id);
    }

    public List<CertificateOfIllness> findByPatientId(Long id) {
        return certificateOfIllnessRepo.findByPatientId(id);
    }
}
