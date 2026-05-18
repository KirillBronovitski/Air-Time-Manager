package com.example.air_time_manager.validation;

import com.example.air_time_manager.validation.exceptions.DataNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolationException() {
        return ResponseEntity.status(409).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException() {
        return ResponseEntity.badRequest().build();
    }


    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> handleDataNotFoundException() {
        return ResponseEntity.notFound().build();
    }
}
