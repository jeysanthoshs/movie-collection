package com.api.movie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/timeOfDay")
public class TimeController {

    @GetMapping
    public String getDateTime(){

        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM YYYY hh:mm a"));
    }
}
