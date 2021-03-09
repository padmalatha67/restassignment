package com.springboot.restassignment.exception;


import com.springboot.restassignment.entity.Claim;
import com.springboot.restassignment.entity.Provider;
import org.hibernate.annotations.NotFound;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class GenericExceptionHandler  {

   @ExceptionHandler
    ResponseEntity handle(Exception e) {
       e.printStackTrace();
        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "generic exception",
                System.currentTimeMillis());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);

    }

   /* @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleResourceNotFound(
            ResourceNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "resource not found",
                System.currentTimeMillis());
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

     @ExceptionHandler(NumberFormatException.class)
    protected ResponseEntity<ErrorResponse> handleNumberFormatException(
             NumberFormatException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "please enter a number",
                System.currentTimeMillis());
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(
            DataIntegrityViolationException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Data has Conflict",
                System.currentTimeMillis());
        return new ResponseEntity(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorResponse> handleMessageNotReadableException(
            HttpMessageNotReadableException ex
    ){
        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Message should be in right format",
                System.currentTimeMillis());
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/


}
