package com.college.e_commarce.service;

import com.college.e_commarce.dto.ProductCreateDto;
import com.college.e_commarce.dto.ProductResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SellerService {
    List<ProductResponseDto> getAllMyProducts();

    ProductResponseDto createProduct(ProductCreateDto productCreateDto, MultipartFile image) throws Exception;

    void deleteProductById(Long productId);
}
