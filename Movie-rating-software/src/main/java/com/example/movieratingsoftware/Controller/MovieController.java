package com.example.movieratingsoftware.Controller;


import com.example.movieratingsoftware.Model.Movie;
import com.example.movieratingsoftware.Service.MovieService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getMovies() {
        List<Movie> movies = movieService.getMovies();
        return ResponseEntity.status(200).body(movies);
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("done add");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@PathVariable Integer id, @Valid @RequestBody Movie movie) {
        movieService.updateMovie(id, movie);
        return ResponseEntity.status(200).body("done updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("done deletes");
    }

    @GetMapping("/get-by-title/{title}")
    public ResponseEntity findMovieByTitle(@PathVariable String title) {
        Movie movie = movieService.findMovieByTitle(title);
        return ResponseEntity.status(200).body(movie);
    }

    @GetMapping("/get-duration/{nameOfMovie}")
    public ResponseEntity howDurationForMovie(@PathVariable String nameOfMovie) {
        Integer durationOfMovie = movieService.howDurationForMovie(nameOfMovie);
        return ResponseEntity.status(200).body(durationOfMovie);
    }

    @GetMapping("/get-name-director/{nameOfMovie}")
    public ResponseEntity directorForThisMovie(@PathVariable String nameOfMovie) {
        String nameOfDirector = movieService.directorForThisMovie(nameOfMovie);
        return ResponseEntity.status(200).body(nameOfDirector);
    }

    @GetMapping("/get-moives-for-director/{nameOfDirector}")
    public ResponseEntity getMoviesForDirector(@PathVariable String nameOfDirector) {
        List<Movie> movies = movieService.getMoviesForDirector(nameOfDirector);
        return ResponseEntity.status(200).body(movies);
    }

    @GetMapping("/how-rate/{nameOfMovie}")
    public ResponseEntity howRateForMovie(@PathVariable String nameOfMovie) {
        Integer numberOfRate = movieService.howRateForMovie(nameOfMovie);
        return ResponseEntity.status(200).body(numberOfRate);
    }

    @GetMapping("/get-movies-above-rate/{rate}")
    public ResponseEntity findMoviesByRatingGreaterThan(@PathVariable Integer rate) {
        List<Movie> movies = movieService.findMoviesByRatingGreaterThan(rate);
        return ResponseEntity.status(200).body(movies);
    }

    @GetMapping("/get-movies-by-genre/{genre}")
    public ResponseEntity findMoviesByGenre(@PathVariable String genre) {
        List<Movie> movies = movieService.findMoviesByGenre(genre);
        return ResponseEntity.status(200).body(movies);
    }


}
