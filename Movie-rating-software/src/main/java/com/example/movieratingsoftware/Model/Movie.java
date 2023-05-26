package com.example.movieratingsoftware.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
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
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 2, message = "name must length more than 2")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String name;
    @Pattern(regexp = "\\b(?:Drama|Action|Comedy)\\b")
    @Column(columnDefinition = "varchar(10) not null")
    private String genre;
    @Min(value = 1, message = "must be between 1-5")
    @Max(value = 5, message = "must be between 1-5")
    @Column(columnDefinition = "int not null")
    private Integer rating;
    @Min(value = 60, message = "must be more than 60")
    @Column(columnDefinition = "int not null")
    private Integer duration;
    private Integer directorID;
}
