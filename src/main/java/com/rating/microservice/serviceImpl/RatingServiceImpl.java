package com.rating.microservice.serviceImpl;

import com.rating.microservice.dto.RatingDto;
import com.rating.microservice.entity.Rating;
import com.rating.microservice.exception.ResourceNotFoundException;
import com.rating.microservice.repository.RatingRepository;
import com.rating.microservice.service.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RatingDto createRating(RatingDto ratingDto) {
        Rating map = this.modelMapper.map(ratingDto, Rating.class);
        Rating save = this.ratingRepository.save(map);
        return this.modelMapper.map(save, RatingDto.class);
    }

    @Override
    public List<RatingDto> getAllRatings() {

        List<Rating> all = this.ratingRepository.findAll();
        return all.stream().map(rating-> this.modelMapper.map(rating, RatingDto.class)).collect(Collectors.toList());

    }

    @Override
    public List<RatingDto> getRatingByUser(int userid) {
        List<Rating> byUserID = this.ratingRepository.findByUserId(userid);
        return byUserID.stream().map(rating-> this.modelMapper.map(rating, RatingDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<RatingDto> getRatingByHotel(int hotelId) {
        List<Rating> all = this.ratingRepository.getByHotels(hotelId);
        return all.stream().map(rating-> this.modelMapper.map(rating, RatingDto.class)).collect(Collectors.toList());
    }

    @Override
    public RatingDto getByRatingId(int ratingId) {
        Rating rating = this.ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("rating", "ratingId", ratingId));
        return this.modelMapper.map(rating, RatingDto.class);
    }

    @Override
    public RatingDto updateRating(RatingDto ratingDto, int ratingId) {

        Rating rating = this.ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("rating", "ratingId", ratingId));
        rating.setRating(ratingDto.getRating());
        rating.setFeedback(ratingDto.getFeedback());
        rating.setHotelId(ratingDto.getHotelId());
        rating.setUserId(ratingDto.getUserId());

        Rating save = this.ratingRepository.save(rating);

        return this.modelMapper.map(save, RatingDto.class);

    }

    @Override
    public String deleteRating(int ratingId) {
        Rating rating = this.ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("rating", "ratingId", ratingId));
        this.ratingRepository.delete(rating);
        return "rating deleted...";
    }
}
