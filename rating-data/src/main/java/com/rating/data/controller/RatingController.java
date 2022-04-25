package com.rating.data.controller;

import com.rating.data.dto.UserRating;
import com.rating.data.dto.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @GetMapping("/{movieId}")
    private Rating getRatings(@PathVariable String movieId) {
        return new Rating(movieId, 4);
    }

    @GetMapping("/user/{userId}")
    private UserRating getRatingsByUserId(@PathVariable String userId) {
        List<Rating> ratings = Arrays.asList(new Rating("100", 4),
                new Rating("102", 2));

        UserRating userRating = new UserRating(ratings);
        userRating.setRatings(ratings);
        return userRating;
    }
}
