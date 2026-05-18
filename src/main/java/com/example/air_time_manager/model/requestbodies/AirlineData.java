package com.example.air_time_manager.model.requestbodies;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AirlineData(

        @NotNull
        @NotBlank
        String name

) {}
