package com.college.e_commarce.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {

    @NotBlank(message = "username is required")
    private String name;

    @Email(message = "Enter correct email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password should required")
    @Size(min = 3, message = "password length minimum is 3")
    private String password;

    @NotBlank(message = "address is required")
    private String address;

    @Builder.Default
    private String role = "USER";

}
