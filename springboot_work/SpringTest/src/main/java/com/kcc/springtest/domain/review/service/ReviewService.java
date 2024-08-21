package com.kcc.springtest.domain.review.service;

import com.kcc.springtest.domain.review.model.PageResponse;
import com.kcc.springtest.domain.review.model.Review;
import com.kcc.springtest.domain.review.model.ReviewPageResponse;
import com.kcc.springtest.domain.review.model.ReviewResponse;
import com.kcc.springtest.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Transactional
    public void saveReview(Review review) {
        reviewRepository.saveReview(review);
    }

    @Transactional
    public void deleteReview(Long id) {
        reviewRepository.deleteReview(id);
    }

    public ReviewPageResponse findReviews(Long restaurantId, int pageNumber) {
        int limit = 5;

        Map<String, Long> map = new HashMap<>();
        map.put("restaurant_id", restaurantId);
        map.put("offset", (((long) pageNumber * limit) - 1));
        map.put("limit", (long) limit);
        List<ReviewResponse> reviewResponses = reviewRepository.findAll(map);
        Float avgScore = reviewRepository.findAvgScore(restaurantId);


        return ReviewPageResponse.of(avgScore, reviewResponses, new PageResponse(pageNumber * limit - 1, limit));
    }
}
