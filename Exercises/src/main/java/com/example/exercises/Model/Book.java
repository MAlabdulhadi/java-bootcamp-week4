package com.example.exercises.Model;

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

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 4, max = 25, message = "the title must be between 4 and 25")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String title;
    @Size(min = 4, max = 25, message = "the author must be between 4 and 25")
    @Column(columnDefinition = "varchar(20) not null")
    private String author;
    @Pattern(regexp = "\\b(?:Academic|Mystery|Novel)\\b", message = "category must be Academic or Mystery or Novel")
    @Column(columnDefinition = "varchar(20) not null check ( category='Academic' or category='Mystery' or category='Novel')")
    private String category;
    @Column(columnDefinition = "int not null unique")
    private Integer ISBN;
    @Min(value = 50, message = "number of pages minimum 50 or above")
    @Column(columnDefinition = "int not null")
    private Integer numberOfPages;


}
