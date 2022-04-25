package com.movie.catalog.controller;

import com.movie.catalog.dto.MovieCatalog;
import com.movie.catalog.dto.MovieInfo;
import com.movie.catalog.dto.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    private final RestTemplate restTemplate;

    public MovieCatalogController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{userID}")
    public List<MovieCatalog> getMovieCatalogs(@PathVariable String userID) {

        UserRating userRating = restTemplate.getForObject("http://rating-data-service/rating/user/" + userID, UserRating.class);
        return userRating.getRatings().stream().map(rating -> {

            MovieInfo movieInfo = restTemplate.getForObject("http://movie-info-service/info/" + rating.getMovieId(), MovieInfo.class);

            return new MovieCatalog(movieInfo.getName(), "test description", rating.getRating());


        }).collect(Collectors.toList());

    }
}
