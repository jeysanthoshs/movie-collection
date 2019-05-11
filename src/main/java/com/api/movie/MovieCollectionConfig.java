package com.api.movie;


import com.api.movie.service.MovieService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.api.movie")
public class MovieCollectionConfig {

    @Bean
    public MovieService movieService(){
        return new MovieService();
    }
}
