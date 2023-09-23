package com.rating.microservice.repository;

import com.rating.microservice.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    List<Rating> findByUserId(int userId);

    @Query(value = "select r from Rating r where r.hotelId= :hotelId")
    List<Rating> getByHotels(@Param("hotelId") int hotelId);

}
