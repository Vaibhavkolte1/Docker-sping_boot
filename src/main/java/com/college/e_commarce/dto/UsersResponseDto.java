package com.college.e_commarce.dto;

import com.college.e_commarce.enums.Role;
import com.college.e_commarce.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersResponseDto {
    private Long id;
    private String name;
    private String email;
    private String address;
    private Role role;
    private UserStatus active;
}
