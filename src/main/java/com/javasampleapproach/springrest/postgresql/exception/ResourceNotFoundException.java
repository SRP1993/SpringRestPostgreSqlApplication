package com.javasampleapproach.springrest.postgresql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {};
    public ResourceNotFoundException(String message,Throwable cause){};
    public ResourceNotFoundException(String message){};
    public ResourceNotFoundException(Throwable cause) {};
}
