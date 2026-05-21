package com.example.air_time_manager.model.requestbodies;

import jakarta.validation.constraints.NotNull;

public record DeletionConfirmation(@NotNull Boolean answer) {
}
