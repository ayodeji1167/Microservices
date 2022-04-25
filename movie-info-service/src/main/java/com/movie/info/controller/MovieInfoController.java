package com.movie.info.controller;

import com.movie.info.dto.MovieInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class MovieInfoController {

    @GetMapping("/{movieID}")
    public MovieInfo getMovieById(@PathVariable String movieID) {
        return new MovieInfo(movieID, "roy");
    }
}
