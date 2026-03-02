package com.college.e_commarce.dto;

import com.college.e_commarce.entity.CartProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {
    private List<CartProductDto> cartProductList = new ArrayList<>();
}
