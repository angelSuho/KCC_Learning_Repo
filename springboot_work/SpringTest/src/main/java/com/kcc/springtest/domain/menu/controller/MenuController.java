package com.kcc.springtest.domain.menu.controller;

import com.kcc.springtest.domain.menu.model.Menu;
import com.kcc.springtest.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menus")
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/{restaurantId}")
    public ResponseEntity<Menu> createMenu(@PathVariable(value = "restaurantId") Long id, @RequestBody Menu menu) {
        menuService.saveMenu(id, menu);
        return ResponseEntity.created(URI.create("/" + menu.getId())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable(value = "id") Long id) {
        menuService.deleteMenu(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Menu>> getMenus(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(menuService.findAll(id));
    }
}
