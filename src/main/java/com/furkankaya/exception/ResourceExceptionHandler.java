package com.furkankaya.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<?> resourceNotFound(ResourceNotFoundException resourceNotFoundException) {
        String details = resourceNotFoundException.getMessage();
        ErrorResponse errorResponse = new ErrorResponse("ID Is Empty",details);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {IllegalAccessError.class})
    public ResponseEntity<?> illegalAccessException() {
        return new ResponseEntity<>("Wrong Parameter", HttpStatus.BAD_REQUEST);
    }

}
