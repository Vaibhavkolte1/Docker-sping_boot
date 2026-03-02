package com.college.e_commarce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private BigDecimal totalAmount;
}
