package com.example.air_time_manager.data.repositories;

import com.example.air_time_manager.data.entities.AirlineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirlineRepository extends JpaRepository<AirlineEntity, Long> {

    Optional<AirlineEntity> findByName(String name);

}
