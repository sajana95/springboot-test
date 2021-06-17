package com.app.sajana.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = RecordNotFoundException.class)
    public void handleNotFoundExceptions(HttpServletResponse response,
                                         RecordNotFoundException exception){
        response.setStatus(HttpStatus.BAD_REQUEST.value(),exception.getMessage());
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(value = InvalidDataException.class)
    public void handleInvalidDataExceptions(HttpServletResponse response,
                                            InvalidDataException exception) {
        response.setStatus(HttpStatus.BAD_REQUEST.value(),exception.getMessage());
    }

}
