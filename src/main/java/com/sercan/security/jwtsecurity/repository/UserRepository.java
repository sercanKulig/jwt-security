package com.sercan.security.jwtsecurity.repository;

import com.sercan.security.jwtsecurity.entity.JwtUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<JwtUser, Long> {
}
