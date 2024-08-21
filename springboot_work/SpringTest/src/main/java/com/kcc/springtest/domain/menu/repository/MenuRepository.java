package com.kcc.springtest.domain.menu.repository;

import com.kcc.springtest.domain.menu.model.Menu;

import java.util.List;

public interface MenuRepository {
    void saveMenu(Menu menu);
    List<Menu> saveMenus(List<Menu> menus);
    void deleteMenu(Long id);
    void deleteMenusByRestaurantId(Long restaurant_id);
    void updateMenu(Menu menu);
    Menu findById(Long id);
    List<Menu> findAll(Long id);
}
