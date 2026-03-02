package com.college.e_commarce.controller;

import com.college.e_commarce.dto.RatingRequestDto;
import com.college.e_commarce.service.RatingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    @PatchMapping
    public ResponseEntity<String> giveRating(@Valid @RequestBody RatingRequestDto dto) {
        ratingService.giveRating(dto);
        return ResponseEntity.ok("rating posted");
    }
}
