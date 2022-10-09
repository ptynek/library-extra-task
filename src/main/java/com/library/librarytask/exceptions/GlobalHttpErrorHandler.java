package com.library.librarytask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CopyBookException.class)
    public ResponseEntity<Object> copyBookNotFoundException(CopyBookException exception){
        return new ResponseEntity<>("Copybook with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReaderException.class)
    public ResponseEntity<Object> readerNotFoundException(ReaderException exception){
        return new ResponseEntity<>("Reader with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RentsException.class)
    public ResponseEntity<Object> rentNotFoundException(RentsException exception){
        return new ResponseEntity<>("Rent with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StatusException.class)
    public ResponseEntity<Object> statusNotFoundException(StatusException exception){
        return new ResponseEntity<>("Status with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TitleException.class)
    public ResponseEntity<Object> titleNotFoundException(TitleException exception){
        return new ResponseEntity<>("Title with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }
}
