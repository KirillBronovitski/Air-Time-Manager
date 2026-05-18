package com.example.air_time_manager.data.repositories;

import com.example.air_time_manager.data.entities.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<AirportEntity, Long> {

    Optional<AirportEntity> findByName(String name);

}
