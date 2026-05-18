package com.example.air_time_manager.validation.constraints.validators;

import com.example.air_time_manager.validation.constraints.annotations.RegionId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.ZoneId;

public class RegionIdValidator implements ConstraintValidator<RegionId, String> {

    @Override
    public void initialize(RegionId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ZoneId.getAvailableZoneIds().contains(value);
    }
}
