package com.college.e_commarce.controller;

import com.college.e_commarce.dto.AddToCartDto;
import com.college.e_commarce.dto.CartProductDto;
import com.college.e_commarce.dto.CartResponseDto;
import com.college.e_commarce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping("/get-item/{id}")
    public ResponseEntity<CartProductDto> getMyCartProduct(@PathVariable Long id) {
        return ResponseEntity.ok(cartService.getMyCartById(id));
    }

    @GetMapping("/get")
    public ResponseEntity<CartResponseDto> getMyCart() {
        return ResponseEntity.ok(cartService.getMyCart());
    }

    @PostMapping("/add-item")
    public ResponseEntity<String> addItemInCart(@RequestBody AddToCartDto dto) {
        return ResponseEntity.ok(cartService.addItemInCart(dto));
    }

    @DeleteMapping("/delet-item/{id}")
    public ResponseEntity<String> removeItem(@PathVariable Long id) {
        cartService.removeItemFromCart(id);
        return ResponseEntity.ok("Item removed successfully");
    }
}
