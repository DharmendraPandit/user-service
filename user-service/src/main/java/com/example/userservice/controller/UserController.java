package com.example.userservice.controller;

import com.example.userservice.domain.User;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/test")
    public ResponseEntity<?> test(@RequestParam String name) {
        String user = "Welcome! "+ name;
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/test2/{age}")
    public ResponseEntity<?> test(@PathVariable int age) {
        String user = "Welcome! "+ age;
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        return new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
    }

}
