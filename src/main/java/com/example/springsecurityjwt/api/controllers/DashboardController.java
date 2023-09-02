package com.example.springsecurityjwt.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping("/salam")
    public ResponseEntity<String> getSalam(){

        return ResponseEntity.ok("Salam!!!");
    }
}
