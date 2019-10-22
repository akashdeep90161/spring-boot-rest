package com.akash.springboot.demo.rest;

import com.akash.springboot.demo.exception.ApplicatioError;
import com.akash.springboot.demo.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Value("${api_doc_url}")
    private String details;

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApplicatioError> handleCustomerNotFoundException(CustomerNotFoundException excepion, WebRequest webRequest)
    {
        ApplicatioError error=new ApplicatioError();
        error.setCode(101);
        error.setMessage(excepion.getMessage());
        error.setDetails(details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
}