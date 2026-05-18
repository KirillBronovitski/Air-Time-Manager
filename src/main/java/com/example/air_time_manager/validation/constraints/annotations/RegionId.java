package com.example.air_time_manager.validation.constraints.annotations;

import com.example.air_time_manager.validation.constraints.validators.RegionIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RegionIdValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface RegionId {

    String message() default "Invalid region id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
