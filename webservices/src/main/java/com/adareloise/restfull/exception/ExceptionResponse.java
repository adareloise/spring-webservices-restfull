package com.adareloise.restfull.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
	
	public Date timestamp;
	public String message;
	public String details;
    private HttpStatus httpStatus;

	
}
