package com.banksystem.core.exception.handler;

import com.banksystem.core.exception.BusinessException;
import com.banksystem.core.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//todo: add logs
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<UnhandledExceptionData> handle(Throwable ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(UnhandledExceptionData.from(ex));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BusinessExceptionData> handle(BusinessException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BusinessExceptionData.from(ex));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundExceptionData> handle(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(NotFoundExceptionData.from(ex));
    }

}
