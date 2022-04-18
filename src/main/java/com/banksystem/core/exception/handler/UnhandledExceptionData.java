package com.banksystem.core.exception.handler;

import com.banksystem.core.exception.BaseErrorResponse;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UnhandledExceptionData {

    private final Boolean success;
    private final BaseErrorResponse body;

    @JsonCreator
    public UnhandledExceptionData(@JsonProperty("success") Boolean success,
                                 @JsonProperty("body") BaseErrorResponse body) {
        this.success = success;
        this.body = body;
    }

    public static UnhandledExceptionData from(Throwable ex) {
        if (ex == null) {
            return null;
        }

        BaseErrorResponse body = new BaseErrorResponse(ex.getMessage(), ex.getCause());
        return new UnhandledExceptionData(false, body);
    }

}
