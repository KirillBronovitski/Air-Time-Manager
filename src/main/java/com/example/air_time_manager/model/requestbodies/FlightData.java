package com.example.air_time_manager.model.requestbodies;

import com.example.air_time_manager.validation.constraints.annotations.InTime;
import com.example.air_time_manager.validation.constraints.annotations.Instant;
import com.example.air_time_manager.validation.constraints.markers.CrossFieldCheck;
import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@GroupSequence({FlightData.class, CrossFieldCheck.class})
@InTime(startField = "UTCStartTime", endField = "UTCEndTime", groups = {CrossFieldCheck.class})
public record FlightData(

        @NotNull
        @NotBlank
        String planeName,

        @NotNull
        @NotBlank
        String from,

        @NotNull
        @NotBlank
        String to,

        @NotNull
        @NotBlank
        @Instant(exact = true)
        String UTCStartTime,

        @Instant
        String UTCEndTime

) {
}
