package com.example.springsecurityjwt.business.abstractes;

import com.example.springsecurityjwt.core.untilitues.result.DataResult;
import com.example.springsecurityjwt.dataAccess.dtos.UserDto;
import com.example.springsecurityjwt.dataAccess.dtos.UserRequestDto;
import com.example.springsecurityjwt.dataAccess.dtos.UserResponse;


public interface UserService {

    public DataResult<UserResponse> add(UserDto userDto);
    public DataResult<UserResponse> login(UserRequestDto userRequestDto);
}
