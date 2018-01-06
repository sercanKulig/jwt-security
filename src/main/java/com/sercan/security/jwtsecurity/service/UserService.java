package com.sercan.security.jwtsecurity.service;

import com.sercan.security.jwtsecurity.entity.JwtUser;

public interface UserService {
    Iterable<JwtUser> getUserList();
    JwtUser getUser(Long id);
    boolean checkUserExist(JwtUser jwtUser);
}
