package com.api.movie.controller;

import com.api.movie.entity.Time;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/timeOfDay")
public class TimeController {

    @GetMapping
    public Time getDateTime(@RequestHeader HttpHeaders headers){



        Time currentTime = new Time();

        String serverTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM YYYY hh:mm a"));
        currentTime.setCurrentServerTime(serverTime);

        return currentTime;
    }
}
