package com.banksystem.core.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class ResponseUserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private OffsetDateTime addedDate;
    private OffsetDateTime modifiedDate;
}
