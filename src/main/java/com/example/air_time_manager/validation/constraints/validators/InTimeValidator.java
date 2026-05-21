package com.example.air_time_manager.validation.constraints.validators;

import com.example.air_time_manager.validation.constraints.annotations.InTime;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.Instant;

public class InTimeValidator implements ConstraintValidator<InTime, Object> {

    private String startField;
    private String endField;

    @Override
    public void initialize(InTime constraintAnnotation) {
        startField = constraintAnnotation.startField();
        endField = constraintAnnotation.endField();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        try {
            String startTime = (String) obj.getClass().getMethod(startField).invoke(obj);
            String endTime = (String) obj.getClass().getMethod(endField).invoke(obj);
            if (startTime != null && startTime.trim().equalsIgnoreCase("UNKNOWN")) {
                startTime = null;
            }
            if (endTime != null && endTime.trim().equalsIgnoreCase("UNKNOWN")) {
                endTime = null;
            }
            if (startTime == null || endTime == null) {
                return startTime != null;
            }
            return Instant.parse(startTime).compareTo(Instant.parse(endTime)) < 0;
        } catch (Exception e) {
            return false;
        }

    }

}
