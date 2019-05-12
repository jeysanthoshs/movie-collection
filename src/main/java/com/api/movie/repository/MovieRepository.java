package com.api.movie.repository;

import com.api.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    //@Query("select m from Movie m where m.name containing ?1")
    List<Movie> findByNameContainingIgnoreCase(String name);

    List<Movie> findByReleaseYear(int year);

    List<Movie> findByRatingGreaterThan(BigDecimal rating);

    List<Movie> findByNameContainingIgnoreCaseAndReleaseYearAndRatingGreaterThan(String name, int year, BigDecimal rating);

    List<Movie> findByNameContainingIgnoreCaseAndReleaseYear(String name, int year);

    List<Movie> findByNameContainingIgnoreCaseAndRatingGreaterThan(String name, BigDecimal rating);

    List<Movie> findByReleaseYearAndRatingGreaterThan(int year, BigDecimal rating);
}
