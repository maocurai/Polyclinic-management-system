package com.example.springApp.repos;

import com.example.springApp.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {
    List<City> findAll();
    City findByid(Long id);
    @Query(
            value = "SELECT DISTINCT c.id AS Id, c.name AS Name\n" +
                    "FROM medical_institution AS mi\n" +
                    "INNER JOIN address AS a\n" +
                    "ON mi.address_id = a.id\n" +
                    "INNER JOIN city AS c\n" +
                    "ON a.city_id = c.id\n" +
                    "ORDER BY c.name ASC",
            nativeQuery = true
    )
    List<City> findCitiesWithMedicalInstitutions();
}
