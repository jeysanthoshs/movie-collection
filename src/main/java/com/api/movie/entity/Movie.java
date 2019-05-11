package com.api.movie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String genere;
    private int releaseYear;
    private BigDecimal rating;

    public Movie(String name, String genere, int releaseYear, BigDecimal rating){
        this.name=name;
        this.genere=genere;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public Movie(Long movieId){
        this.id=movieId;
    }

    public Movie(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genere='" + genere + '\'' +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                '}';
    }
}
