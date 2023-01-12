package com.acmeflix.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@Entity
@Table( name = "USERS", indexes =  {@Index(columnList = "email")})
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class User extends BaseModel {

    @NotNull( message = "Email can not be null")
    @Column(length = 50, nullable = false, unique = true)
    private String email; //This one will the user use to sign in

    @NotNull ( message = "First name can not be null")
    @Column(length = 50, nullable = false)
    private String firstName;

    @NotNull ( message = "First name can not be null")
    @Column(length = 50, nullable = false)
    private String lastName;

    @NotNull ( message = "Last name can not be null")
    @Column(length = 50, nullable = false)
    private String password; //Just leave it simple, a plain text string also will stored to the DB
}
