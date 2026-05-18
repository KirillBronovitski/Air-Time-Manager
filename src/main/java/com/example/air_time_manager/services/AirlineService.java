package com.example.air_time_manager.services;

import com.example.air_time_manager.data.entities.AirlineEntity;
import com.example.air_time_manager.data.entities.PlaneEntity;
import com.example.air_time_manager.data.repositories.AirlineRepository;
import com.example.air_time_manager.model.Airline;
import com.example.air_time_manager.model.requestbodies.AirlineData;
import com.example.air_time_manager.validation.exceptions.DataNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepo;

    public AirlineService(AirlineRepository airlineRepo) {
        this.airlineRepo = airlineRepo;
    }

    public List<Airline> getAirlines() {
        List<Airline> airlines = new ArrayList<>();
        for (AirlineEntity airlineEntity: airlineRepo.findAll(Sort.by(Sort.Direction.ASC, "name"))) {
            airlines.add(mapEntityToDto(airlineEntity));
        }
        return airlines;
    }

    public AirlineEntity getAirlineEntity(String name) {
        AirlineEntity airlineEntity = airlineRepo.findByName(name).orElse(null);
        if (airlineEntity == null) {
            throw new DataNotFoundException(String.format("No airline with name \"%s\" found", name));
        }
        return airlineEntity;
    }

    public Airline getAirline(String name) {
        return mapEntityToDto(getAirlineEntity(name));
    }

    public Airline saveAirline(AirlineData airlineData) {
        String name = airlineData.name().replaceAll("\\s+", "-");
        AirlineEntity airlineEntity = new AirlineEntity(name);
        airlineRepo.save(airlineEntity);
        return getAirline(name);
    }

    private Airline mapEntityToDto(AirlineEntity entity) {
        return new Airline(
                entity.getId(),
                entity.getName(),
                entity.getPlanes().stream().map(PlaneEntity::getName).toList()
                );
    }
}
