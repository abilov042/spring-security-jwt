package com.example.springsecurityjwt.business.concretes;

import com.example.springsecurityjwt.business.abstractes.UserService;

import com.example.springsecurityjwt.core.untilitues.result.DataResult;
import com.example.springsecurityjwt.core.untilitues.result.SuccessDataResult;
import com.example.springsecurityjwt.dataAccess.abstracts.UserDao;
import com.example.springsecurityjwt.dataAccess.dtos.UserDto;
import com.example.springsecurityjwt.dataAccess.dtos.UserRequestDto;
import com.example.springsecurityjwt.dataAccess.dtos.UserResponse;
import com.example.springsecurityjwt.entities.ERole;
import com.example.springsecurityjwt.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserManager implements UserService {



    UserDao userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

}
