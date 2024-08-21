package com.kcc.springtest.domain.menu.service;

import com.kcc.springtest.domain.menu.model.Menu;
import com.kcc.springtest.domain.menu.repository.MenuRepository;
import com.kcc.springtest.domain.menu.repository.vo.MenuVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenuService {
    private final MenuRepository menuRepository;

    @Transactional
    public void saveMenu(Long restaurant_id, Menu menu) {
        menu.setRestaurant_id(restaurant_id);
        menuRepository.saveMenu(menu);
    }

    @Transactional
    public void deleteMenu(Long id) {
        menuRepository.deleteMenu(id);
    }

    @Transactional
    public void deleteMenusByRestaurantId(Long restaurant_id) {
        menuRepository.deleteMenusByRestaurantId(restaurant_id);
    }

    @Transactional
    public void updateMenu(Menu menu) {
        menuRepository.updateMenu(menu);
    }

    public Menu findById(Long id) {
        return menuRepository.findById(id);
    }

    public List<Menu> findAll(Long restaurant_id) {
        return menuRepository.findAll(restaurant_id);
    }
}
