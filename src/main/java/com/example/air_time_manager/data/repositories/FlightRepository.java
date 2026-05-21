package com.example.air_time_manager.data.repositories;

import com.example.air_time_manager.data.entities.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightEntity, Long> {}
