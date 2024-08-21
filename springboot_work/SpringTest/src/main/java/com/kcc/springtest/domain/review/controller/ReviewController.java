package com.kcc.springtest.domain.review.controller;

import com.kcc.springtest.domain.review.model.Review;
import com.kcc.springtest.domain.review.model.ReviewPageResponse;
import com.kcc.springtest.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public ResponseEntity<Void> createReview(@RequestBody Review review) {
        reviewService.saveReview(review);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/review/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable(value = "id") Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/restaurant/{restaurantId}/reviews")
    public ResponseEntity<ReviewPageResponse> getReviews(@PathVariable(value = "restaurantId") Long id,
                                                         @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        return ResponseEntity.ok().body(reviewService.findReviews(id, pageNumber));
    }

}
