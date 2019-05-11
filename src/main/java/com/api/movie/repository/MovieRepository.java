package com.api.movie.repository;

import com.api.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m from Movie m where m.name like '%?1%'")
    List<Movie> findByNameLike(String name);
}
