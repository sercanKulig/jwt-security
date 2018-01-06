package com.sercan.security.jwtsecurity.security;

import com.sercan.security.jwtsecurity.entity.JwtUser;
import com.sercan.security.jwtsecurity.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    private UserService userService;

    @Autowired
    public JwtGenerator(UserService userService) {
        this.userService = userService;
    }

    public String generate(JwtUser jwtUser) {
        if(jwtUser.getId() <= 0
                || (jwtUser.getUserName() == null  && jwtUser.getUserName().isEmpty())
                || (jwtUser.getPassword() == null && jwtUser.getPassword().isEmpty())
                || (jwtUser.getRole() == null && jwtUser.getRole().isEmpty())) {
            throw new RuntimeException("Value is missing");
        }
        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
}
