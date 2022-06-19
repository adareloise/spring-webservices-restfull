package com.adareloise.restfull.exception.global;

import org.springframework.dao.DataAccessException;

@SuppressWarnings("serial")
public class UserNotFoundException extends DataAccessException{
	
    public UserNotFoundException(String s) {
        super(s);
    }

    public UserNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
