package com.kcc.springtest.domain.menu.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu {

    private Long id;
    private String name;
    private int price;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private Long restaurant_id;

}
