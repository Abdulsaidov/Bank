package com.banksystem.core.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseErrorResponse {

    private String message;
    private Throwable cause;
    private Date time;

    public BaseErrorResponse(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
        this.time = new Date();
    }
}
