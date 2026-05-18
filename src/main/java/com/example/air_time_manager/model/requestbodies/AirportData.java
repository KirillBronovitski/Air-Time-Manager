package com.example.air_time_manager.model.requestbodies;

import com.example.air_time_manager.validation.constraints.annotations.RegionId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AirportData(
        @NotNull
        @NotBlank
        String name,

        @NotNull
        @NotBlank
        @RegionId
        String regionId

) {}
