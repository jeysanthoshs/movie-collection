package com.api.movie.service;

import com.api.movie.entity.Movie;
import com.api.movie.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
        return this.movieRepository.findByNameLike(name);
    }

    public Movie updateMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        this.movieRepository.delete(new Movie(movieId));
    }
}
