package com.kcc.springtest.domain.menu.repository;

import com.kcc.springtest.domain.menu.model.Menu;
import com.kcc.springtest.domain.menu.repository.mapper.MenuMapper;
import com.kcc.springtest.domain.menu.repository.vo.MenuVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuRepository{
    private final MenuMapper menuMapper;

    @Override
    public void saveMenu(Menu menu) {
        menuMapper.saveMenu(menu);
    }

    @Override
    public List<Menu> saveMenus(List<Menu> menus) {
        return menuMapper.saveMenus(menus);
    }

    @Override
    public void deleteMenu(Long id) {
        menuMapper.deleteMenu(id);
    }

    @Override
    public void deleteMenusByRestaurantId(Long restaurant_id) {
        menuMapper.deleteMenusByRestaurantId(restaurant_id);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuMapper.updateMenu(menu);
    }

    @Override
    public Menu findById(Long id) {
        return menuMapper.findById(id);
    }

    @Override
    public List<Menu> findAll(Long restaurant_id) {
        return menuMapper.findAll(restaurant_id);
    }
}
