package com.college.e_commarce.service;

import com.college.e_commarce.dto.ProductCreateDto;
import com.college.e_commarce.dto.ProductResponseDto;

import java.util.List;

public interface SellerService {
    List<ProductResponseDto> getAllMyProducts();

    ProductResponseDto createProduct(ProductCreateDto productCreateDto);

    void deleteProductById(Long productId);
}
