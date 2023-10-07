package com.calculator.api.calculatorapi.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse(String message, String details, Date timestamp) {
        super();
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
