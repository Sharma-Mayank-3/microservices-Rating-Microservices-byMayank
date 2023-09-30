package com.rating.microservice.service;

import com.rating.microservice.dto.RatingDto;
import com.rating.microservice.entity.Rating;

import java.util.List;

public interface RatingService {

    RatingDto createRating(RatingDto ratingDto);

    List<RatingDto> getAllRatings();

    List<RatingDto> getRatingByUser(int userid);

    List<RatingDto> getRatingByHotel(int hotelId);

    RatingDto getByRatingId(int ratingId);

    RatingDto updateRating(RatingDto ratingDto, int ratingId);

    String deleteRating(int ratingId);
}
