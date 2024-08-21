package com.kcc.springtest.domain.menu.repository.mapper;

import com.kcc.springtest.domain.menu.model.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    void saveMenu(Menu menu);
    List<Menu> saveMenus(List<Menu> menus);
    void deleteMenu(Long id);
    void deleteMenusByRestaurantId(Long restaurant_id);
    void updateMenu(Menu menu);
    Menu findById(Long id);
    List<Menu> findAll(Long restaurant_id);
}
