package com.college.e_commarce.service;

import com.college.e_commarce.dto.AddToCartDto;
import com.college.e_commarce.dto.CartProductDto;
import com.college.e_commarce.dto.CartResponseDto;

public interface CartService {

    String addItemInCart(AddToCartDto dto);

    CartProductDto getMyCartById(Long id);

    CartResponseDto getMyCart();

    void removeItemFromCart(Long cartProductId);
}
