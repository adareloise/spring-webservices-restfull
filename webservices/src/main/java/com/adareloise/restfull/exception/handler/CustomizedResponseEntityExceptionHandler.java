package com.adareloise.restfull.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.adareloise.restfull.exception.ExceptionResponse;
import com.adareloise.restfull.exception.global.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request ){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false),
						HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> userNotFoundException(Exception ex, WebRequest request ){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false),
						HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
}

