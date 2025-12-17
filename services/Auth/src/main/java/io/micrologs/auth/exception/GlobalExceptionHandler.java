package io.micrologs.auth.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.micrologs.auth.dto.ErrorResponse;
import io.micrologs.auth.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MicroLogsAuthException.class)
    public ResponseEntity<ResponseDTO<ErrorResponse>> handleAuthException(MicroLogsAuthException exception) {
        log.error("MicroLogsAuthException Occoured : {}", exception);

        ErrorResponse er = new ErrorResponse(exception.getMessage(), 400, LocalDateTime.now());
        ResponseDTO<ErrorResponse> resp = new ResponseDTO<>("Exception Occoured", false, er);
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO<ErrorResponse>> handleException(Exception exception) {
        log.error("Exception Occoured in AUTH : {}", exception);

        ErrorResponse er = new ErrorResponse(exception.getMessage(), 400, LocalDateTime.now());
        ResponseDTO<ErrorResponse> resp = new ResponseDTO<>("Exception Occoured", false, er);
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

}
