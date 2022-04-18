package com.banksystem.core.exception;

import lombok.Getter;

import java.io.Serializable;
import java.text.MessageFormat;

@Getter
public class NotFoundException extends RuntimeException {

    private final Class clazz;
    private final Serializable id;

    public NotFoundException(Serializable id, Class clazz) {
        this(MessageFormat.format("Entity ''{0}'' #{1} was not found.", clazz, id), null, id, clazz);
    }

    public NotFoundException(String message, Throwable cause, Serializable id, Class clazz) {
        super(message, cause);
        this.id = id;
        this.clazz = clazz;
    }

}
