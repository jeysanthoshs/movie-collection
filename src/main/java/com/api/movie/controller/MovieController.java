package com.api.movie.controller;

import com.api.movie.entity.Movie;
import com.api.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie createMovie(@RequestBody Movie movie){
       return this.movieService.createMovie(movie);
    }

    @GetMapping(path="/list")
    public List<Movie> getMovies(){
        return this.movieService.getAllMovies();
    }

    @GetMapping(path="/{movie_id}")
    public Movie getMovieById(@PathVariable(name = "movie_id") Long movieId){
        return this.movieService.getMovieById(movieId);
    }

    @GetMapping
    public List<Movie> searchMovie(@RequestParam(name = "name",required = false) String name, @RequestParam(name = "year", required = false) Integer year, @RequestParam(name = "rating", required = false) BigDecimal rating ){

       return this.movieService.searchMovie(name, year, rating);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Movie updateMovie(@RequestBody Movie movie){
        return this.movieService.updateMovie(movie);
    }

    @DeleteMapping(path="/{movie_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable(name = "movie_id") Long movieId){
        this.movieService.deleteMovie(movieId);
    }
}
