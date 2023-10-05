package com.demo.advice;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.custonexception.ErrorResponse;
import com.demo.custonexception.ProperDataException;




@ControllerAdvice


public class ControllerAdvicees {
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(NoSuchElementException.class)
	
	public ResponseEntity<ErrorResponse> handleNoSuchFile(NoSuchElementException excep) {
	    ErrorResponse errorResponse = new ErrorResponse();
	    errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
	    errorResponse.setMessage("No file with that Id Number. Please Try again With Other Id");
	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(InvalidDataAccessResourceUsageException.class)
	public ResponseEntity<ErrorResponse> handleNoSuchFile(InvalidDataAccessApiUsageException excep) {
	    ErrorResponse errorResponse = new ErrorResponse();
	    errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
	    errorResponse.setMessage("No file with that Id Number. Please Try again With Other Id");
	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(ProperDataException.class)
	public ResponseEntity<ErrorResponse> handleProperDataException(ProperDataException excep) {
	    ErrorResponse errorResponse = new ErrorResponse();
	    errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
	    errorResponse.setMessage(excep.getErrorMsg());
	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException excep){
		 String errorMessage = excep.getBindingResult().getFieldErrors().stream()
	                .map(error -> error.getField() + " " + error.getDefaultMessage())
	                .collect(Collectors.joining(", "));
		 
		 ErrorResponse errorResponse = new ErrorResponse();
		    errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		    errorResponse.setMessage(errorMessage);
		    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	 
		
	}
	
	
	

}
