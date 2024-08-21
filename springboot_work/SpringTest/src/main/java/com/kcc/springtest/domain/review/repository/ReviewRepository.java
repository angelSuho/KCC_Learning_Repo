package com.kcc.springtest.domain.review.repository;

import com.kcc.springtest.domain.review.model.Review;
import com.kcc.springtest.domain.review.model.ReviewResponse;

import java.util.List;
import java.util.Map;

public interface ReviewRepository {
    void saveReview(Review review);
    void deleteReview(Long id);
    List<ReviewResponse> findAll(Map<String, Long> map);
    Float findAvgScore(Long restaurantId);
}
