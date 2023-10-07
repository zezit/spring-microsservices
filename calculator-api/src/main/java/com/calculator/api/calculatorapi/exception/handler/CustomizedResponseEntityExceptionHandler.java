package com.calculator.api.calculatorapi.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.calculator.api.calculatorapi.exception.ExceptionResponse;
import com.calculator.api.calculatorapi.exception.UnsuportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception exception, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                exception.getMessage(),
                request.getDescription(false),
                new Date());

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsuportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(Exception exception, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                exception.getMessage(),
                request.getDescription(false),
                new Date());

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
