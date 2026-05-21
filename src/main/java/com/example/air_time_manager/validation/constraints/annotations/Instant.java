package com.example.air_time_manager.validation.constraints.annotations;


import com.example.air_time_manager.validation.constraints.validators.InstantValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = InstantValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Instant {

    String message() default "Invalid time format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean exact() default false;

}
