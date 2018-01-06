package com.sercan.security.jwtsecurity.dao;

import com.sercan.security.jwtsecurity.entity.JwtUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true
)
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean checkUserExist(JwtUser jwtUser) {
        String hql = "FROM JwtUser as usr " +
                "WHERE usr.username = ? " +
                "and usr.password = ?" +
                "and usr.enable = ?" +
                "and usr.role = ?";
        int count = entityManager.createQuery(hql)
                .setParameter(1, jwtUser.getUserName())
                .setParameter(2, jwtUser.getPassword())
                .setParameter(3, jwtUser.getEnable())
                .setParameter(4, jwtUser.getRole())
                .getResultList().size();
        return count > 0;
    }
}
