package com.example.air_time_manager.services;

import com.example.air_time_manager.data.entities.AirlineEntity;
import com.example.air_time_manager.data.entities.AirportEntity;
import com.example.air_time_manager.data.entities.PlaneEntity;
import com.example.air_time_manager.data.repositories.PlaneRepository;
import com.example.air_time_manager.model.Plane;
import com.example.air_time_manager.model.requestbodies.PlaneData;
import com.example.air_time_manager.validation.exceptions.DataNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneService {

    private final PlaneRepository planeRepo;
    private final AirportService airportService;
    private final AirlineService airlineService;


    public PlaneService(PlaneRepository planeRepo, AirportService airportService, AirlineService airlineService) {
        this.planeRepo = planeRepo;
        this.airportService = airportService;
        this.airlineService = airlineService;
    }

    public PlaneEntity getPlaneEntity(String planeName) {
        PlaneEntity planeEntity = planeRepo.findByName(planeName).orElse(null);
        if (planeEntity == null) {
            throw new DataNotFoundException(String.format("Plane with name \"%s\" not found", planeName));
        }
        return planeEntity;
    }

    public Plane getPlane(String planeName) {
        return mapEntityToDto(getPlaneEntity(planeName));
    }

    public List<Plane> getPlanesAtAirport(String airportName) {
        List<Plane> planes = new ArrayList<>();
        for (PlaneEntity planeEntity: planeRepo.findAllAtAirport(airportName, Sort.by(Sort.Order.asc("name")))) {
            planes.add(mapEntityToDto(planeEntity));
        }
        return planes;
    }

    public List<Plane> getPlanesOfAirline(String airline) {
        List<Plane> planes = new ArrayList<>();
        for (PlaneEntity planeEntity: planeRepo.findAllOfAirline(airline, Sort.by(Sort.Order.asc("name")))) {
            planes.add(mapEntityToDto(planeEntity));
        }
        return planes;
    }

    public Plane savePlane(PlaneData planeData) {
        String name = planeData.name();

        AirportEntity homeAirport = airportService.getAirportEntity(planeData.homeAirport().replaceAll("\\s+", "-"));
        AirportEntity currentAirport = airportService.getAirportEntity(planeData.currentAirport().replaceAll("\\s+", "-"));
        AirlineEntity airline = airlineService.getAirlineEntity(planeData.airline().replaceAll("\\s+", "-"));
        PlaneEntity planeEntity = new PlaneEntity(
                name,
                homeAirport,
                currentAirport,
                airline
        );
        planeRepo.save(planeEntity);
        return getPlane(name);
    }

    private Plane mapEntityToDto(PlaneEntity planeEntity) {
        return new Plane(
                planeEntity.getId(),
                planeEntity.getName(),
                planeEntity.getHomeAirport().getName(),
                planeEntity.getCurrentAirport().getName(),
                planeEntity.getAirline().getName()
                );
    }

}
