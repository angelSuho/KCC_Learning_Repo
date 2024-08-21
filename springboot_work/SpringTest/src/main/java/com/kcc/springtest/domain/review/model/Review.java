package com.kcc.springtest.domain.review.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {


    private String content;
    private Double score;

    @JsonProperty("restaurantId")
    private Long restaurant_id;
}
