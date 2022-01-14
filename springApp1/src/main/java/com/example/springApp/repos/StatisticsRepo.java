package com.example.springApp.repos;

import com.example.springApp.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsRepo extends JpaRepository<Patient, Long> {

    @Query(
            value = "SELECT COUNT(cl.id) AS patientsCount, r.name AS regionName\n" +
                    "FROM certificate_of_illness AS cl\n" +
                    "INNER JOIN medical_institution AS mi\n" +
                    "ON cl.medical_institution_id = mi.id\n" +
                    "    INNER JOIN address AS a\n" +
                    "         ON mi.address_id = a.id\n" +
                    "         RIGHT JOIN region AS r\n" +
                    "                    ON a.region_id = r.id\n" +
                    "WHERE disease_id = ?1 OR disease_id IS NULL\n" +
                    "GROUP BY r.id\n" +
                    "ORDER BY patientsCount DESC",
            nativeQuery = true
    )
    List<Statistics> countPatientsWithDiseaseInRegions(Long diseaseId);

    @Query(
            value = "SELECT COUNT(cl.id) AS patientsCount, r.name AS regionName\n" +
                    "FROM certificate_of_illness AS cl\n" +
                    "INNER JOIN patient AS p\n" +
                    "ON cl.patient_id = p.id\n" +
                    "INNER JOIN personal_information AS pi\n" +
                    "ON p.personal_info_id = pi.id\n" +
                    "INNER JOIN address AS a\n" +
                    "ON pi.address_id = a.id\n" +
                    "RIGHT JOIN region AS r\n" +
                    "ON a.region_id = r.id\n" +
                    "WHERE disease_id = ?1 OR disease_id IS NULL\n" +
                    "GROUP BY r.id\n" +
                    "ORDER BY patientsCount DESC",
            nativeQuery = true
    )
    List<Statistics> countPatientsWithDiseaseInRegionsByPatientAddress(Long diseaseId);

    @Query(
            value = "SELECT COUNT(ci.id) AS patientsCount, mi.name AS name\n" +
                    "FROM certificate_of_illness AS ci\n" +
                    "\tRIGHT JOIN medical_institution AS mi\n" +
                    "                    ON ci.medical_institution_id = mi.id\n" +
                    "         INNER JOIN address AS a\n" +
                    "                    ON mi.address_id = a.id\n" +
                    "WHERE a.city_id = ?1\n" +
                    "GROUP BY mi.id\n" +
                    "ORDER BY patientsCount DESC;",
            nativeQuery = true
    )
    List<Statistics> countPatientsInMedicalInstitutionByCity(Long diseaseId);

    @Query(
            value = "SELECT COUNT(cl.disease_id) AS patientsCount, d.name AS diseaseName\n" +
                    "FROM certificate_of_illness AS cl\n" +
                    "RIGHT JOIN disease AS d\n" +
                    "ON cl.disease_id = d.id\n" +
                    "WHERE MONTH(cl.date) = ?1 AND YEAR(cl.date) = ?2\n" +
                    "GROUP BY d.id\n" +
                    "ORDER BY patientsCount DESC",
            nativeQuery = true
    )
    List<Statistics> countCertificatesOfIllnessByMonth(Integer monthNumber, Integer year);

    @Query(
            value = "SELECT DISTINCT YEAR(cl.date) AS years\n" +
                    "FROM certificate_of_illness AS cl\n" +
                    "ORDER BY years DESC",
            nativeQuery = true
    )
    List<Statistics> findAllYears();
}
