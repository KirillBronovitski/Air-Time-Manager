package com.example.air_time_manager.model.requestbodies;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PlaneData(

        @NotNull
        @NotBlank
        String name,

        @NotNull
        @NotBlank
        String homeAirport,

        @NotNull
        @NotBlank
        String currentAirport,

        @NotNull
        @NotBlank
        String airline

) {}
