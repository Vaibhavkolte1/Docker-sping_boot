package com.college.e_commarce.controller;

import com.college.e_commarce.dto.ProductResponseDto;
import com.college.e_commarce.dto.UsersResponseDto;
import com.college.e_commarce.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/users")
    public List<UsersResponseDto> getAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts() {
        return adminService.getAllProducts();
    }

    @PatchMapping("/toogle-block/{userId}")
    public ResponseEntity<String> changeUserStatus(@PathVariable Long userId) {
        adminService.toggleUserStatus(userId);
        return ResponseEntity.ok("User Status changed successfully");
    }

    @DeleteMapping("/product-delete")
    public ResponseEntity<String> deleteProductById(@RequestParam Long productId) {
        adminService.deleteProductById(productId);
        return ResponseEntity.ok("Element deleted successfully!");
    }
}
