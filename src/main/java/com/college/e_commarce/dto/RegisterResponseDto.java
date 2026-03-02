package com.college.e_commarce.dto;

import com.college.e_commarce.enums.Role;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponseDto {
    private Long id;
    private String name;
    private String email;
    private String address;
    private Role role;
    private String jwt;
}
