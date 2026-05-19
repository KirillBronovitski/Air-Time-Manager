package com.example.air_time_manager.services;

import com.example.air_time_manager.data.entities.AirportEntity;
import com.example.air_time_manager.data.entities.PlaneEntity;
import com.example.air_time_manager.data.repositories.AirportRepository;
import com.example.air_time_manager.model.Airport;
import com.example.air_time_manager.model.requestbodies.AirportData;
import com.example.air_time_manager.validation.exceptions.DataNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {

    private final AirportRepository airportRepo;

    public AirportService(AirportRepository airportRepo) {
        this.airportRepo = airportRepo;
    }

    public List<Airport> getAirports() {
        List<Airport> airports = new ArrayList<>();
        for (AirportEntity airportEntity: airportRepo.findAll(Sort.by(Sort.Order.asc("name")))) {
            airports.add(mapEntityToDto(airportEntity));
        }
        return airports;
    }

    public AirportEntity getAirportEntity(String airportName) {
        AirportEntity airportEntity = airportRepo.findByName(airportName).orElse(null);
        if (airportEntity == null) {
            throw new DataNotFoundException(String.format("No airport with name \"%s\" found", airportName));
        }
        return airportEntity;
    }

    public Airport getAirport(String airportName) {
        return mapEntityToDto(getAirportEntity(airportName));
    }

    public Airport saveAirport(AirportData airportData) {
        String name = airportData.name().replaceAll("\\s+", "-");
        AirportEntity airportEntity = new AirportEntity(name, ZoneId.of(airportData.regionId()));
        airportRepo.save(airportEntity);
        return getAirport(name);
    }

    public void deleteAirport(String name) {
        AirportEntity airportEntity = getAirportEntity(name);
        airportRepo.delete(airportEntity);
    }

    public Airport mapEntityToDto(AirportEntity airportEntity) {
        return new Airport(
                airportEntity.getId(),
                airportEntity.getName(),
                airportEntity.getZoneId(),
                airportEntity.getAssignedPlanes().stream().map(PlaneEntity::getName).toList(),
                airportEntity.getPlanesAtAirport().stream().map(PlaneEntity::getName).toList()
                );
    }

}
