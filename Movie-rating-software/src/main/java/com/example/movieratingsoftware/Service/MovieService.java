package com.example.movieratingsoftware.Service;


import com.example.movieratingsoftware.ApiException.ApiException;
import com.example.movieratingsoftware.Model.Director;
import com.example.movieratingsoftware.Model.Movie;
import com.example.movieratingsoftware.Repository.DirectorRepository;
import com.example.movieratingsoftware.Repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;

    public List<Movie> getMovies() {
        List<Movie> movies = movieRepository.findAll();
        if (movies.isEmpty()) {
            throw new ApiException("do not have any moives");
        }
        return movies;
    }

    public void addMovie(Movie movie) {
        Director director = directorRepository.findDirectorById(movie.getDirectorID());
        if (director == null) {
            throw new ApiException("do not have any director by this id");
        }
        movieRepository.save(movie);
    }

    public void updateMovie(Integer id, Movie movie) {
        Movie oldMovie = movieRepository.findMovieById(id);
        if (oldMovie == null) {
            throw new ApiException("do not have any movie by this id");
        }
        oldMovie.setName(movie.getName());
        oldMovie.setDuration(movie.getDuration());
        oldMovie.setRating(movie.getRating());
        oldMovie.setGenre(movie.getGenre());
        Director director = directorRepository.findDirectorById(movie.getDirectorID());
        if (director == null) {
            throw new ApiException("do not have any director by this id");
        }
        oldMovie.setDirectorID(movie.getDirectorID());
        movieRepository.save(oldMovie);
    }

    public void deleteMovie(Integer id) {
        Movie movie = movieRepository.findMovieById(id);
        if (movie == null) {
            throw new ApiException("do not have any movie by this id");
        }
        movieRepository.delete(movie);
    }

    public Movie findMovieByTitle(String title) {
        Movie movie = movieRepository.findMovieByName(title);
        if (movie == null) {
            throw new ApiException("do not have any movie by this title");
        }
        return movie;
    }

    public Integer howDurationForMovie(String nameOfMovie) {
        Movie movie = movieRepository.findMovieByName(nameOfMovie);
        if (movie == null) {
            throw new ApiException("do not have any movie by this name");
        }
        return movie.getDuration();
    }

    public String directorForThisMovie(String nameOfMovie) {
        Movie movie = movieRepository.findMovieByName(nameOfMovie);
        if (movie == null) {
            throw new ApiException("do not have any movie by this name");
        }
        Director director = directorRepository.findDirectorById(movie.getDirectorID());
        return director.getName();
    }

    public List<Movie> getMoviesForDirector(String nameOfDirector) {
        Director director = directorRepository.findDirectorByName(nameOfDirector);
        List<Movie> movies = movieRepository.findMoviesByDirectorID(director.getId());
        if (movies.isEmpty()) {
            throw new ApiException("do not have any movie for this director");
        }
        return movies;
    }

    public Integer howRateForMovie(String nameOfMovie) {
        Movie movie = movieRepository.findMovieByName(nameOfMovie);
        if (movie == null) {
            throw new ApiException("do not have movie by this name");
        }
        return movie.getRating();
    }

    public List<Movie> findMoviesByRatingGreaterThan(Integer rate) {
        List<Movie> movies = movieRepository.findMoviesByRatingGreaterThan(rate);
        if (movies.isEmpty()) {
            throw new ApiException("do not have any movie above this rate");
        }
        return movies;
    }

    public List<Movie> findMoviesByGenre(String genre) {
        List<Movie> movies = movieRepository.findMoviesByGenre(genre);
        if (movies.isEmpty()) {
            throw new ApiException("do not have any movie for this genre");
        }
        return movies;
    }

}
