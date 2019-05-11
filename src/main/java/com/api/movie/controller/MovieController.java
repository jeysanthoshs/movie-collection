package com.api.movie.controller;

import com.api.movie.entity.Movie;
import com.api.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public void createMovie(){
        Movie test = new Movie("test","test",1000,new BigDecimal(3.2));
        this.movieService.createMovie(test);
    }

    @GetMapping
    public List<Movie> getMovies(){
        return this.movieService.getAllMovies();
    }
}
