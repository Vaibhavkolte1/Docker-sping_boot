package com.college.e_commarce.controller;

import com.college.e_commarce.dto.ProductCreateDto;
import com.college.e_commarce.dto.ProductResponseDto;
import com.college.e_commarce.service.SellerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('SELLER')")
@RequestMapping("/seller")
public class SellerController {
    
    private final SellerService sellerService;

    @GetMapping("/my-products")
    public List<ProductResponseDto> getAllMyProducts() {
        return sellerService.getAllMyProducts();
    }

    @PostMapping(value = "/create-product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @ModelAttribute ProductCreateDto productCreateDto,
                                                            @RequestParam MultipartFile image) throws Exception {
        return ResponseEntity.ok(sellerService.createProduct(productCreateDto, image));
    }

    @DeleteMapping("/delete-product")
    public ResponseEntity<String> deleteProductById(@RequestParam Long productId) {
        sellerService.deleteProductById(productId);
        return ResponseEntity.ok("Element deleted successfully!");
    }
}
