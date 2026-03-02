package com.college.e_commarce.service;

import com.college.e_commarce.dto.LoginRequestDto;
import com.college.e_commarce.dto.RegisterResponseDto;
import com.college.e_commarce.dto.RegisterRequestDto;

public interface AuthService {

    RegisterResponseDto getMe();

    RegisterResponseDto loginUser(LoginRequestDto dto);

    RegisterResponseDto registerUser(RegisterRequestDto dto);
}
