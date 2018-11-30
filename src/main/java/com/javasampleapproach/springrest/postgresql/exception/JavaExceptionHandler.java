package com.javasampleapproach.springrest.postgresql.exception;

import com.javasampleapproach.springrest.postgresql.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.ws.rs.BadRequestException;
import java.util.Date;

public class JavaExceptionHandler {

    @RestControllerAdvice
    public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

        @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class})
        protected ResponseEntity<ErrorDetails> handleConflict(RuntimeException runtimeEx, WebRequest webRequest){
            String bodyOdResponse = "Application Specific";
            ErrorDetails errorDetails = new ErrorDetails(new Date(),bodyOdResponse,webRequest.getDescription(true));
            return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.CONFLICT);
        }

        @ExceptionHandler(value = { ResourceNotFoundException.class})
        protected ResponseEntity<ErrorDetails> handleNotFoundException(RuntimeException runtimeEx,WebRequest webRequest){
            ErrorDetails errorDetails=new ErrorDetails(new Date(),runtimeEx.getMessage(),webRequest.getDescription(true));
            return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(value = { BadRequestException.class})
        protected ResponseEntity<ErrorDetails> handleBadRequestException(RuntimeException runtimeEx,WebRequest webRequest){
            ErrorDetails errorDetails=new ErrorDetails(new Date(),runtimeEx.getMessage(),webRequest.getDescription(true));
            return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(value= { InternalServerException.class})
            protected ResponseEntity<ErrorDetails> handleInternalServerException(RuntimeException runtimeEx,WebRequest webRequest){
                ErrorDetails errorDetails = new ErrorDetails(new Date(),runtimeEx.getMessage(),webRequest.getDescription(true));
                return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
