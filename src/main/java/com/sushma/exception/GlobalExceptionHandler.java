package com.sushma.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, Object>> handleValidation(
	            MethodArgumentNotValidException ex) {

	        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();

	        Map<String, Object> error = new HashMap<>();
	        error.put("status", "FAILURE");
	        error.put("errorCode", "VALIDATION_ERROR");
	        error.put("message", errorMessage);
	        error.put("timestamp", LocalDateTime.now());

	        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	    }

	    // 🔴 Generic errors
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {

	        Map<String, Object> error = new HashMap<>();
	        error.put("status", "FAILURE");
	        error.put("errorCode", "INTERNAL_ERROR");
	        error.put("message", ex.getMessage());
	        error.put("timestamp", LocalDateTime.now());

	        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
    
}
