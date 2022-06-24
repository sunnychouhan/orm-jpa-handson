package com.jpa.handson.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handler(ConstraintViolationException constraintViolationException) {
        Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();


        List<String> collect = constraintViolations.stream()
                .map(constraintViolation -> constraintViolation.getConstraintDescriptor().getMessageTemplate())
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(collect);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handler(RuntimeException runtimeException) {
        return ResponseEntity.internalServerError().body("Internal Server Error");
    }
}
