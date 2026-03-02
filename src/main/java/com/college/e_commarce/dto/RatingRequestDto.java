package com.college.e_commarce.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RatingRequestDto {

    @NotNull(message = "id is required")
    private Long id;

    @Min(value = 0)
    @Max(value = 5)
    private int ratings;
}
