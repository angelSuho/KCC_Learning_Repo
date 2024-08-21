package com.kcc.springtest.domain.Restaurant.model;

import com.kcc.springtest.domain.menu.model.Menu;
import com.kcc.springtest.domain.review.model.Review;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {

    private Long id;
    private String name;
    private String address;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private List<Menu> menus;

}
