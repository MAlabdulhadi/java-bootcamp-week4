package com.example.blogsystem.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 30, message = "title must be 30 character or less")
    @Column(columnDefinition = "varchar(30) not null unique ")
    private String title;
    @Column(columnDefinition = "varchar(15) not null check ( category='health' or category='education' or category='programming')")
    @Pattern(regexp = "\\b(?:health|education|programming)\\b", message = "category must be health or education or programming")
    private String category;
    @Size(max = 300)
    @Column(columnDefinition = "varchar(300) not null")
    private String body;
    @Column(columnDefinition = "boolean default false")
    private Boolean isPublished = false;

}
