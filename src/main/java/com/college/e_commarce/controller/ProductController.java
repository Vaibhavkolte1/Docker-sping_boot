package com.college.e_commarce.controller;

import com.college.e_commarce.dto.ProductCreateDto;
import com.college.e_commarce.dto.ProductResponseDto;
import com.college.e_commarce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    
    private final ProductService productService;

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @GetMapping("/search")
    public List<ProductResponseDto> searchProduct(@RequestParam String keyword) {
        return productService.searchProduct(keyword);
    }

    @GetMapping("/get-all")
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }

}
