package com.example.air_time_manager.data.repositories;

import com.example.air_time_manager.data.entities.PlaneEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PlaneRepository extends JpaRepository<PlaneEntity, Long> {

    @Query("SELECT p FROM PlaneEntity p WHERE p.currentAirport.name = :airportName")
    Iterable<PlaneEntity> findAllAtAirport(String airportName, Sort sort);

    @Query("SELECT p FROM PlaneEntity p WHERE p.airline.name = :airline")
    Iterable<PlaneEntity> findAllOfAirline(String airline, Sort sort);

    Optional<PlaneEntity> findByName(String name);

}
