package io.micrologs.auth.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.micrologs.auth.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MicroLogsAuthException.class)
    public ResponseEntity<ErrorResponse> handleException(MicroLogsAuthException exception) {
        ErrorResponse er = new ErrorResponse(exception.getMessage(), 400, LocalDateTime.now());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

}
