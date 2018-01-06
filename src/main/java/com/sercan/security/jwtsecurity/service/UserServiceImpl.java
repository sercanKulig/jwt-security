package com.sercan.security.jwtsecurity.service;

import com.sercan.security.jwtsecurity.dao.UserDao;
import com.sercan.security.jwtsecurity.entity.JwtUser;
import com.sercan.security.jwtsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserDao userDao) {
        this.userRepository = userRepository;
        this.userDao = userDao;
    }

    public Iterable<JwtUser> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public JwtUser getUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public boolean checkUserExist(JwtUser jwtUser) {
        return userDao.checkUserExist(jwtUser);
    }
}
