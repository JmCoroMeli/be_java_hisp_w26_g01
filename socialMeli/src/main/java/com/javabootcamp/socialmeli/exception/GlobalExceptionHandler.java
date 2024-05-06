package com.javabootcamp.socialmeli.exception;

import com.javabootcamp.socialmeli.dto.response.ResponseDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseDto> handleEntityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto(e.getMessage()));
    }
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ResponseDto> handleResponseStatusException(ResourceAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseDto(e.getMessage()));
    }
    @ExceptionHandler(IllegalActionException.class)
    public ResponseEntity<ResponseDto> handleUnsupportedOperationException(IllegalActionException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(e.getMessage()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getFieldErrors());
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(HandlerMethodValidationException ex) {
        String result ="";

        Map<String,List<String>> listErrors = new HashMap<>();
        int contador = 0;
        ex.getAllErrors();
        ex.getAllValidationResults()
                .forEach( e->{

            List<String> list = e.getResolvableErrors().stream().map( r -> r.getDefaultMessage()).toList();

            listErrors.put("error "+contador+1, list);
        });



        Map<String, Map<String,List<String>>> response = new HashMap<>();
        response.put("errors", listErrors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
