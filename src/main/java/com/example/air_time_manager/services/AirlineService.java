package com.example.air_time_manager.services;

import com.example.air_time_manager.data.AirlineEntity;
import com.example.air_time_manager.data.AirlineRepository;
import com.example.air_time_manager.model.Airline;
import com.example.air_time_manager.model.AirlineData;
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

    public Airline getAirline(String name) {
        Airline airline = mapEntityToDto(airlineRepo.findByName(name).orElse(null));
        if (airline == null) {
            throw new DataNotFoundException(String.format("No airline with name \"%s\" found", name));
        }
        return airline;
    }

    public Airline saveAirline(AirlineData airlineData) {
        AirlineEntity airlineEntity = new AirlineEntity(airlineData.name());
        airlineRepo.save(airlineEntity);
        return mapEntityToDto(airlineRepo.findByName(airlineData.name()).orElse(null));
    }

    private Airline mapEntityToDto(AirlineEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Airline(
                entity.getId(),
                entity.getName()
                );
    }
}
