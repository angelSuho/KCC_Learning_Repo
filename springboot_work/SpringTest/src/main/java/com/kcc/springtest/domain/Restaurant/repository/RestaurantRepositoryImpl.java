package com.kcc.springtest.domain.Restaurant.repository;

import com.kcc.springtest.domain.Restaurant.model.Restaurant;
import com.kcc.springtest.domain.Restaurant.model.RestaurantResponse;
import com.kcc.springtest.domain.Restaurant.repository.mapper.RestaurantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepository {
    private final RestaurantMapper restaurantMapper;

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        restaurantMapper.saveRestaurant(restaurant);
        return restaurant;
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantMapper.deleteRestaurant(id);
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        restaurantMapper.updateRestaurant(restaurant);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantMapper.findAll();
    }

    @Override
    public Optional<RestaurantResponse> findById(Long id) {
        return restaurantMapper.findById(id);
    }
}
