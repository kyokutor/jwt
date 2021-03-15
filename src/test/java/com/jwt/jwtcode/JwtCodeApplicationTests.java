package com.jwt.jwtcode;

import com.jwt.jwtcode.model.User;
import com.jwt.jwtcode.server.UserService;
import com.jwt.jwtcode.userdao.UserDaoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class JwtCodeApplicationTests {

    @Autowired
    public UserService userDao;


    @Test
    void contextLoads() {

        User us=new User();
        us.setName("测试账户001");
        us.setPassword("123456");
        User login = userDao.Login(us);

        System.out.println(login.getId());

    }

}
