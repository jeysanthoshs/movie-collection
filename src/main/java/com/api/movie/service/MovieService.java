package com.api.movie.service;

import com.api.movie.entity.Movie;
import com.api.movie.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class MovieService {

    private static Logger LOGGER = LoggerFactory.getLogger("MovieService");

    @Autowired
    private MovieRepository movieRepository;

    public Movie createMovie(Movie movie){
        return this.movieRepository.save(movie);
    }

    public List<Movie> getAllMovies(){

       return this.movieRepository.findAll();
    }

    public Movie getMovieById(Long movieId) {
        return this.movieRepository.findById(movieId).orElse(null);
    }

    public List<Movie> getMovieByName(String name) {
        return this.movieRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Movie> searchMovie(String name, Integer year, BigDecimal rating){

        boolean isNameSearch = name != null;
        boolean isYearSearch = year != null;
        boolean isRatingSearch = rating != null;

        if(isNameSearch&&isYearSearch&&isRatingSearch){
            return this.movieRepository.findByNameContainingIgnoreCaseAndReleaseYearAndRatingGreaterThan(name, year, rating);
        }

        if(isNameSearch && isYearSearch){
           return this.movieRepository.findByNameContainingIgnoreCaseAndReleaseYear(name, year);
        }

        if(isNameSearch && isRatingSearch){
            return this.movieRepository.findByNameContainingIgnoreCaseAndRatingGreaterThan(name, rating);
        }

        if(isYearSearch && isRatingSearch){
            return this.movieRepository.findByReleaseYearAndRatingGreaterThan(year, rating);
        }

        if(isNameSearch)
            return this.movieRepository.findByNameContainingIgnoreCase(name);
        if(isYearSearch)
            return this.movieRepository.findByReleaseYear(year);
        if(isRatingSearch)
            return this.movieRepository.findByRatingGreaterThan(rating);

        return this.movieRepository.findAll();
    }

    public Movie updateMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        this.movieRepository.delete(new Movie(movieId));
    }
}
