package com.example.air_time_manager.validation.constraints.validators;

import com.example.air_time_manager.validation.constraints.annotations.Instant;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.format.DateTimeParseException;

public class InstantValidator implements ConstraintValidator<Instant, String> {

    private boolean exact;

    @Override
    public void initialize(Instant constraintAnnotation) {
       exact = constraintAnnotation.exact();
    }

    @Override
    public boolean isValid(String instantString, ConstraintValidatorContext context) {
        if (!exact && (instantString == null || instantString.trim().equalsIgnoreCase("UNKNOWN"))) {
            return true;
        }
        if (instantString == null) {
            return false;
        }
        try {
            java.time.Instant.parse(instantString);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
