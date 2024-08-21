package com.kcc.springtest.domain.Restaurant.controller;

import com.kcc.springtest.domain.Restaurant.model.Restaurant;
import com.kcc.springtest.domain.Restaurant.model.RestaurantResponse;
import com.kcc.springtest.domain.Restaurant.service.RestaurantService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("restaurant")
    public ResponseEntity<Void> createRestaurant(HttpServletRequest request,
                                                 @RequestBody @Validated Restaurant restaurant) {
        restaurantService.saveRestaurant(restaurant);
        return ResponseEntity.created(URI.create(request.getRequestURL() + "/" + restaurant.getId())).build();
    }

    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/restaurant/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id,
                                                       @RequestBody @Validated Restaurant restaurant) {
        restaurantService.updateRestaurant(id, restaurant);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<RestaurantResponse> getRestaurant(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(restaurantService.findById(id));
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        return ResponseEntity.ok().body(restaurantService.findAll());
    }

}
