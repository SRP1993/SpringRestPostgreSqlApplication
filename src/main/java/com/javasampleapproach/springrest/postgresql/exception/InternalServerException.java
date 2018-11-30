package com.javasampleapproach.springrest.postgresql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException {

    public InternalServerException(){}
    public InternalServerException(String message,Throwable cause){}
    public InternalServerException(String message){}
    public InternalServerException(Throwable cause){}

}
