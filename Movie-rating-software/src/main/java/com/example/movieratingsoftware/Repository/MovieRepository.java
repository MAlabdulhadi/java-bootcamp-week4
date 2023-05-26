package com.example.movieratingsoftware.Repository;


import com.example.movieratingsoftware.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findMovieById(Integer id);

    Movie findMovieByName(String title);

    List<Movie> findMoviesByDirectorID(Integer id);

    List<Movie> findMoviesByRatingGreaterThan(Integer rate);

    List<Movie> findMoviesByGenre(String genre);

}
