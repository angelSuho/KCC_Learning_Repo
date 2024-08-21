package com.kcc.springtest.domain.Restaurant.repository;

import com.kcc.springtest.domain.Restaurant.model.Restaurant;
import com.kcc.springtest.domain.Restaurant.model.RestaurantResponse;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {
    Restaurant saveRestaurant(Restaurant restaurant);
    void deleteRestaurant(Long id);
    void updateRestaurant(Restaurant restaurant);
    Optional<RestaurantResponse> findById(Long id);
    List<Restaurant> findAll();
}
