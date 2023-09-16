package com.example.springsecurityjwt.api.controllers;

import com.example.springsecurityjwt.dataAccess.abstracts.UserDao;
import com.example.springsecurityjwt.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/salam")
    public ResponseEntity<String> getSalam(){

        return ResponseEntity.ok("Salam!!!");
    }

    @GetMapping("/getall")
    public List<User> getAll(){

        return this.userDao.findAll();
    }
}
