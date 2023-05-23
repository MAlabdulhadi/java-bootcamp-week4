package com.example.homework17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class User {
    //User class: ID , name , username , password, email ,role, age

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name can't be empty")
    @Size(min = 4, message = "Length more than 4")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotEmpty(message = "user name can't be empty")
    @Size(min = 4, message = "Length more than 4")
    @Column(columnDefinition = "VARCHAR(20) unique not null")
    private String userName;
    @NotEmpty(message = "password can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;
    @Email(message = "must be email vaild")
    @Column(columnDefinition = "varchar(30) unique not null ")
    private String email;
    @NotEmpty(message = "role can't be empty")
    @Column(columnDefinition = "varchar(20) not null check ( role='user' or role='admin')")
    @Pattern(regexp = "\\b(?:user|admin)\\b")
    private String role;
    @NotNull(message = "role can't be empty")
    @Column(columnDefinition = "int not null ")
    private int age;


}

