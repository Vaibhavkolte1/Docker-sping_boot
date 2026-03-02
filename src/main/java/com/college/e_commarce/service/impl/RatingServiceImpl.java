package com.college.e_commarce.service.impl;

import com.college.e_commarce.dto.RatingRequestDto;
import com.college.e_commarce.entity.Product;
import com.college.e_commarce.repository.ProductRepository;
import com.college.e_commarce.service.RatingService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void giveRating(RatingRequestDto dto) {
        Product isExistsProduct = productRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        int newReviewCount = isExistsProduct.getNoOfReview() + 1;
        int newTotalRatings = isExistsProduct.getTotalRatings() + dto.getRatings();

        isExistsProduct.setNoOfReview(newReviewCount);
        isExistsProduct.setTotalRatings(newTotalRatings);

        float avgRating = (float) newTotalRatings / newReviewCount;
        isExistsProduct.setRatings(avgRating);

    }
}
