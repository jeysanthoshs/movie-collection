package com.api.movie.controller;

import com.api.movie.entity.Movie;
import com.api.movie.service.MovieService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MovieController.class, secure = false)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    Movie mockMovie = new Movie("The Shawshank Redemption","Drama",1994,new BigDecimal("9.2"));

    @Test
    public void createMovie() throws Exception{
        mockMovie.setId(Long.valueOf(1));
        Mockito.when(movieService.createMovie(Mockito.any())).thenReturn(mockMovie);
        String mockMovieJson = new ObjectMapper().writeValueAsString(mockMovie);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/movie").accept(MediaType.APPLICATION_JSON).content(mockMovieJson).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        String expectedOutput = "{id:1,genere:Drama,releaseYear:1994,rating:9.2}";
        JSONAssert.assertEquals(expectedOutput, response.getContentAsString(),false);
    }

    @Test
    public void getMovies() throws Exception{
        mockMovie.setId(Long.valueOf(1));
        Mockito.when(movieService.getAllMovies()).thenReturn(Arrays.asList(mockMovie,mockMovie));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/movie/list").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedOutput = "[{id:1,genere:Drama,releaseYear:1994,rating:9.2},{id:1,genere:Drama,releaseYear:1994,rating:9.2}]";
        JSONAssert.assertEquals(expectedOutput, result.getResponse().getContentAsString(),false);
    }

    @Test
    public void getMovieById() throws Exception {
        mockMovie.setId(Long.valueOf(1));
        Mockito.when(movieService.getMovieById(Mockito.anyLong())).thenReturn(mockMovie);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/movie/1").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedOutput = "{id:1,genere:Drama,releaseYear:1994,rating:9.2}";
        JSONAssert.assertEquals(expectedOutput, result.getResponse().getContentAsString(),false);

    }

    @Test
    public void getMovieByName() throws Exception {
        mockMovie.setId(Long.valueOf(1));
        Mockito.when(movieService.getMovieByName(Mockito.any())).thenReturn(Arrays.asList(mockMovie,mockMovie));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/movie?name=test").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedOutput = "[{id:1,genere:Drama,releaseYear:1994,rating:9.2},{id:1,genere:Drama,releaseYear:1994,rating:9.2}]";
        JSONAssert.assertEquals(expectedOutput, result.getResponse().getContentAsString(),false);
    }

    @Test
    public void updateMovie() throws Exception{
        mockMovie.setId(Long.valueOf(2));
        mockMovie.setRating(new BigDecimal("9.4"));
        Mockito.when(movieService.updateMovie(Mockito.any())).thenReturn(mockMovie);
        String mockMovieJson = new ObjectMapper().writeValueAsString(mockMovie);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/movie").accept(MediaType.APPLICATION_JSON).content(mockMovieJson).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        String expectedOutput = "{id:2,genere:Drama,releaseYear:1994,rating:9.4}";
        JSONAssert.assertEquals(expectedOutput, response.getContentAsString(),false);
    }

    @Test
    public void deleteMovie() throws Exception{
        mockMovie.setId(Long.valueOf(1));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/movie/1").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}