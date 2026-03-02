package com.college.e_commarce.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDto {

    @NotBlank(message = "name is required")
    private String name;

    private String description;

    @DecimalMin(value = "0.01", message = "price should greater than 0")
    private BigDecimal price;

    @Min(value = 0)
    private int stock;

    private String image;

}
