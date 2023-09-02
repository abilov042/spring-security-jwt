package com.example.springsecurityjwt.business.abstractes;

import com.example.springsecurityjwt.dataAccess.dtos.UserDto;
import com.example.springsecurityjwt.dataAccess.dtos.UserRequestDto;
import com.example.springsecurityjwt.dataAccess.dtos.UserResponse;


public interface UserService {

    public UserResponse add(UserDto userDto);
    public UserResponse login(UserRequestDto userRequestDto);
}
