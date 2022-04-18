package com.banksystem.core.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final String message;

    public BusinessException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

}
