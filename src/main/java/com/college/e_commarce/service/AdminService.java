package com.college.e_commarce.service;

import com.college.e_commarce.dto.ProductResponseDto;
import com.college.e_commarce.dto.UsersResponseDto;

import java.util.List;

public interface AdminService {
    List<UsersResponseDto> getAllUsers();
    List<ProductResponseDto> getAllProducts();

    void toggleUserStatus(Long id);
    void deleteProductById(Long productId);
}
