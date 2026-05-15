package com.example.air_time_manager.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirlineRepository extends JpaRepository<AirlineEntity, Long> {

    Optional<AirlineEntity> findByName(String name);

}
