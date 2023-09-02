package com.example.springsecurityjwt.business.concretes;

import com.example.springsecurityjwt.business.abstractes.UserService;

import com.example.springsecurityjwt.dataAccess.abstracts.UserDao;
import com.example.springsecurityjwt.dataAccess.dtos.UserDto;
import com.example.springsecurityjwt.dataAccess.dtos.UserRequestDto;
import com.example.springsecurityjwt.dataAccess.dtos.UserResponse;
import com.example.springsecurityjwt.entities.Role;
import com.example.springsecurityjwt.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserDao userDao;
    private final JwtManager jwtManager;
    private final AuthenticationManager authenticationManager;
    @Override
    public UserResponse add(UserDto userDto) {

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(Role.USER);
        this.userDao.save(user);
        String token = jwtManager.generateToken(user);


        return UserResponse.builder().token(token).build();
    }

    @Override
    public UserResponse login(UserRequestDto userRequestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequestDto.getUsername(), userRequestDto.getPassword()));
        User user = userDao.findByUsername(userRequestDto.getUsername()).orElseThrow();

        String token = jwtManager.generateToken(user);
        return UserResponse.builder().token(token).build();
    }
}
