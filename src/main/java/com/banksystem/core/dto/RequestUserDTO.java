package com.banksystem.core.dto;

import com.banksystem.core.entity.Locale;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class RequestUserDTO {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Email
    @NotEmpty
    private String email;
    @Enumerated(EnumType.STRING)
    private Locale locale;
    @NotEmpty
    @Pattern(message = "Введите корректный номер телефона", regexp = "^(8|\\+7)\\d{10}$")
    private String phoneNumber;

}
