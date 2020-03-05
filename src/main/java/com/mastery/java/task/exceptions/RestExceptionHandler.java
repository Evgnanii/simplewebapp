package com.mastery.java.task.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchEmployeeException.class)
    public ResponseEntity<Object> handleNoSuchEmployeeException(NoSuchEmployeeException c) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), c.getMessage());
        return new ResponseEntity(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoEmployeesException.class)
    public ResponseEntity<Object> handleNoEmployeesException(NoEmployeesException c) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), c.getMessage());
        return new ResponseEntity(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestBodyException.class)
    public ResponseEntity<Object> handleBadRequestBodyException(BadRequestBodyException c) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), c.getMessage());
        return new ResponseEntity(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<Object> handleBadRequestBodyException(EmployeeAlreadyExistsException c) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), c.getMessage());
        return new ResponseEntity(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
