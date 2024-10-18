package com.workintech.zoo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ZooGlobalExceptionHandler {
    @ExceptionHandler(ZooException.class)
    public ResponseEntity<ZooErrorResponse> zooErrorExceptionHandler(ZooException zooException){
        ZooErrorResponse zooErrorResponse = new ZooErrorResponse(zooException.getMessage(),zooException.getStatus().value(),System.currentTimeMillis());
        return new ResponseEntity<>(zooErrorResponse,zooException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> zooErrorExceptionHandler(Exception exception){
        ZooErrorResponse errorResponse = new ZooErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
