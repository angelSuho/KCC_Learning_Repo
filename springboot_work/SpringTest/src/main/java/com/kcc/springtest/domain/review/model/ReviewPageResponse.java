package com.kcc.springtest.domain.review.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewPageResponse {
    Float avgScore;
    List<ReviewResponse> reviews;
    PageResponse page;

    @Builder
    private ReviewPageResponse(Float avgScore, List<ReviewResponse> reviews, PageResponse page) {
        this.avgScore = avgScore;
        this.reviews = reviews;
        this.page = page;
    }

    public static ReviewPageResponse of(Float avgScore, List<ReviewResponse> reviews, PageResponse page) {
        return ReviewPageResponse.builder()
                .avgScore(avgScore)
                .reviews(reviews)
                .page(page)
                .build();
    }
}
