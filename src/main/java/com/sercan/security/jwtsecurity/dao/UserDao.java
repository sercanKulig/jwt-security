package com.sercan.security.jwtsecurity.dao;

import com.sercan.security.jwtsecurity.entity.JwtUser;

public interface UserDao {
    boolean checkUserExist(JwtUser jwtUser);
}
