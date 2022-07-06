package com.banksystem.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "first_name", length = 127, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 127, nullable = false)
    private String lastName;

    @Column(name = "email", length = 256, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "locale_name", length = 50, nullable = false)
    private Locale locale;

    @Column(name = "phone_number", length = 50)
    private String phoneNumber;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "added_date", nullable = false)
    private OffsetDateTime addedDate;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private OffsetDateTime modifiedDate;

    // тут конечно интересно, надо пообсуждать. использование маппера на одной чаше весов, а протектед конструктор на другой
    public User() { }

    public User(String firstName, String lastName, String email,
                Locale locale, String phoneNumber, Boolean isDeleted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.locale = locale;
        this.phoneNumber = phoneNumber;
        this.isDeleted = isDeleted;
    }

}
