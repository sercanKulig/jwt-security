package com.sercan.security.jwtsecurity.controller;

import com.sercan.security.jwtsecurity.entity.JwtUser;
import com.sercan.security.jwtsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public Iterable<JwtUser> getUsers() {
        return userService.getUserList();
    }
}
