package com.example.exercises.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 4, max = 25, message = "the name must be between 4 and 30")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @Size(min = 4, max = 15, message = "the username must be between 4 and 15")
    @Column(columnDefinition = "varchar(15) not null unique")
    private String userName;
    @Size(min = 8, message = "the password minimum 8")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "weak password")
    private String password;
    @Email(message = "email must be valid")
    @Column(columnDefinition = "varchar(40) not null unique")
    private String email;


}
