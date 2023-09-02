package com.example.springsecurityjwt.api.controllers;

import com.example.springsecurityjwt.business.abstractes.UserService;
import com.example.springsecurityjwt.dataAccess.dtos.UserDto;
import com.example.springsecurityjwt.dataAccess.dtos.UserRequestDto;
import com.example.springsecurityjwt.dataAccess.dtos.UserResponse;
import com.example.springsecurityjwt.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/login")
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> add(@RequestBody UserDto userDto){


        return ResponseEntity.ok(userService.add(userDto));

    }

    @PostMapping("/authon")
    public ResponseEntity<?> login(UserRequestDto userRequestDto){

        return ResponseEntity.ok(userService.login(userRequestDto));
    }

    @GetMapping("/yeni")
    public ResponseEntity<String> getYeni(){

        return ResponseEntity.ok("Yeni");
    }
}
