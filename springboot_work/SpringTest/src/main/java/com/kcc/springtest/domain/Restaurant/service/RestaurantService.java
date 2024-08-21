package com.kcc.springtest.domain.Restaurant.service;

import com.kcc.springtest.domain.Restaurant.model.Restaurant;
import com.kcc.springtest.domain.Restaurant.model.RestaurantResponse;
import com.kcc.springtest.domain.Restaurant.repository.RestaurantRepository;
import com.kcc.springtest.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    private final MenuService menuService;

    @Transactional
    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.saveRestaurant(restaurant);

        restaurant.getMenus().forEach(menu -> {
            menuService.saveMenu(restaurant.getId(), menu);
        });
//        menuRepository.saveMenus(restaurant.getMenus());
    }

    @Transactional
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteRestaurant(id);
    }

    @Transactional
    public void updateRestaurant(Long id, Restaurant restaurant) {
        restaurant.setId(id);
        restaurantRepository.updateRestaurant(restaurant);
        RestaurantResponse restaurantResponse = restaurantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 레스토랑입니다."));
        menuService.deleteMenusByRestaurantId(restaurantResponse.getId());

        restaurant.getMenus().forEach(menu -> {
            menuService.saveMenu(restaurant.getId(), menu);
        });
    }

    public RestaurantResponse findById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 레스토랑입니다."));
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }
}
