package com.college.e_commarce.service.impl;

import com.college.e_commarce.dto.AddToCartDto;
import com.college.e_commarce.dto.CartProductDto;
import com.college.e_commarce.dto.CartResponseDto;
import com.college.e_commarce.entity.Cart;
import com.college.e_commarce.entity.CartProduct;
import com.college.e_commarce.entity.Product;
import com.college.e_commarce.entity.User;
import com.college.e_commarce.repository.CartProductRepository;
import com.college.e_commarce.repository.CartRepository;
import com.college.e_commarce.repository.ProductRepository;
import com.college.e_commarce.service.CartService;
import com.college.e_commarce.util.AuthUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final AuthUtil authUtil;
    private final CartProductRepository cartProductRepository;

    @Override
    @Transactional
    public String addItemInCart(AddToCartDto dto) {

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        User owner = authUtil.getCurrentUser();

        Cart cart = cartRepository.findByOwner(owner)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Optional<CartProduct> existingCartProduct = cart.getCartProducts()
                .stream()
                .filter(item -> item.getProduct().getId().equals(product.getId()))
                .findFirst();

        if (existingCartProduct.isPresent()) {
            CartProduct cartProduct = existingCartProduct.get();

            int updatedQuantity = cartProduct.getQuantity() + dto.getQuantity();
            cartProduct.setQuantity(updatedQuantity);

            BigDecimal updatedTotal = product.getPrice()
                    .multiply(BigDecimal.valueOf(updatedQuantity));

            cartProduct.setTotalAmount(updatedTotal);

        } else {

            BigDecimal totalAmount = product.getPrice()
                    .multiply(BigDecimal.valueOf(dto.getQuantity()));

            CartProduct newCartProduct = CartProduct.builder()
                    .name(product.getName())
                    .price(product.getPrice())
                    .quantity(dto.getQuantity())
                    .totalAmount(totalAmount)
                    .createdAt(LocalDateTime.now())
                    .product(product)
                    .cart(cart)
                    .build();

            cart.getCartProducts().add(newCartProduct);
        }

        return "Product added to cart successfully";
    }

    @Override
    public CartProductDto getMyCartById(Long id) {
        User owner = authUtil.getCurrentUser();
        Cart cart = cartRepository.findByOwner(owner)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        CartProduct cartProduct = cartProductRepository.findByIdAndCart(id, cart)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        return CartProductDto.builder()
                .id(cartProduct.getId())
                .name(cartProduct.getName())
                .price(cartProduct.getPrice())
                .quantity(cartProduct.getQuantity())
                .totalAmount(cartProduct.getTotalAmount())
                .build();
    }

    @Override
    public CartResponseDto getMyCart() {
        User owner = authUtil.getCurrentUser();

        Cart cart = cartRepository.findByOwner(owner)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        List<CartProductDto> cartitemList = cart.getCartProducts().stream()
                .map(cartItem -> CartProductDto.builder()
                        .id(cartItem.getId())
                        .name(cartItem.getName())
                        .price(cartItem.getPrice())
                        .quantity(cartItem.getQuantity())
                        .totalAmount(cartItem.getTotalAmount())
                        .build())
                .toList();

        return CartResponseDto.builder().cartProductList(cartitemList).build();
    }

    @Override
    @Transactional
    public void removeItemFromCart(Long cartProductId) {

        User owner = authUtil.getCurrentUser();

        Cart cart = cartRepository.findByOwner(owner)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        CartProduct cartProduct = cartProductRepository
                .findByIdAndCart(cartProductId, cart)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        cart.getCartProducts().remove(cartProduct);
    }

}
