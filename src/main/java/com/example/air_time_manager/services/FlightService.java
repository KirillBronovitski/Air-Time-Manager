package com.example.air_time_manager.services;

import com.example.air_time_manager.data.entities.AirportEntity;
import com.example.air_time_manager.data.entities.FlightEntity;
import com.example.air_time_manager.data.entities.PlaneEntity;
import com.example.air_time_manager.data.repositories.FlightRepository;
import com.example.air_time_manager.model.Flight;
import com.example.air_time_manager.model.answerbodies.DeletionFeedback;
import com.example.air_time_manager.model.requestbodies.DeletionConfirmation;
import com.example.air_time_manager.model.requestbodies.FlightData;
import com.example.air_time_manager.validation.exceptions.DataNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private final FlightRepository flightRepo;
    private final AirportService airportService;
    private final PlaneService planeService;

    public FlightService(FlightRepository flightRepo, AirportService airportService, PlaneService planeService) {
        this.flightRepo = flightRepo;
        this.airportService = airportService;
        this.planeService = planeService;
    }

    public FlightEntity getFlightEntity(Long id) {
        FlightEntity flightEntity = flightRepo.findById(id).orElse(null);
        if (flightEntity == null) {
            throw new DataNotFoundException("No flight found with id " + id);
        }
        return flightEntity;
    }

    public Flight getFlight(Long id) {
        return mapEntityToDto(getFlightEntity(id));
    }

    public Flight saveFlight(FlightData flightData) {
        AirportEntity to = airportService.getAirportEntity(flightData.to().replaceAll("\\s+", "-"));
        AirportEntity from = airportService.getAirportEntity(flightData.from().replaceAll("\\s+", "-"));
        PlaneEntity plane = planeService.getPlaneEntity(flightData.planeName().replaceAll("\\s+", "-"));
        String UTCStartTime = flightData.UTCStartTime();
        String UTCEndTime = flightData.UTCEndTime();
        FlightEntity flightEntity = new FlightEntity(
                plane,
                from,
                to,
                UTCStartTime == null ? "UNKNOWN" : UTCStartTime,
                UTCEndTime == null ? "UNKNOWN" : UTCEndTime);
        flightRepo.save(flightEntity);
        return mapEntityToDto(flightEntity);
    }

    public DeletionFeedback deleteFlight(Long id, DeletionConfirmation deletionConfirmation) {
        if (deletionConfirmation.answer()) {
            FlightEntity flightEntity = getFlightEntity(id);
            flightRepo.delete(flightEntity);
            return new DeletionFeedback(String.format("Flight with id %d deleted successfully", id));
        }
        return new DeletionFeedback(String.format("Flight with id %d not deleted: action was not confirmed", id));
    }

    public DeletionFeedback deleteAllFlights(DeletionConfirmation deletionConfirmation) {
        if (deletionConfirmation.answer()) {
            flightRepo.deleteAll();
            return new DeletionFeedback("All flights deleted successfully");
        }
        return new DeletionFeedback("No flights deleted: action was not confirmed");
    }

    private Flight mapEntityToDto(FlightEntity flightEntity) {
        return new Flight(
                flightEntity.getId(),
                flightEntity.getPlane().getName(),
                flightEntity.getFrom().getName(),
                flightEntity.getTo().getName(),
                flightEntity.getUTCStartTime(),
                flightEntity.getUTCEndTime()
        );
    }

}
