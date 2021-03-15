package com.jwt.jwtcode.server.impl;

import com.jwt.jwtcode.model.User;
import com.jwt.jwtcode.server.UserService;
import com.jwt.jwtcode.userdao.UserDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Xu dong  ren
 * @date 2021/3/15
 */
@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserDaoMapper userDao;


    @Override
    public User Login(User user) {
        User userDB = userDao.Login(user);
        if(userDB!=null) {
            return userDB;
        }
        throw new RuntimeException("认证失败！");
    }
}
