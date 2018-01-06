package com.sercan.security.jwtsecurity.entity;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.persistence.*;

@Entity
@Table(name = "authentication_token")
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    @Id
    @Column(name = "authentication_token_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;

    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
