package io.micrologs.article.util.exception;

import io.micrologs.article.util.ResponseHandler;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler
{
    @Autowired
    private HttpServletRequest request;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseHandler.generateResponse("Validation failed for user input" , HttpStatus.BAD_REQUEST , errors);
    }

    @ExceptionHandler(UserDisplayException.class)
    public ResponseEntity<Object> handleUserDisplayExceptions(UserDisplayException ex) {
        Map<String, String> errors = new HashMap<>();
        log.error(request.getRequestURL().toString());
        log.error("Exception message , status {} , {}" , ex.getMessage() , ex.getStatus() );
        log.error("Exception occurred", ex);
        return ResponseHandler.generateResponse(ex.message, ex.status, errors);
    }


}
