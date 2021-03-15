package com.jwt.jwtcode.server;

import com.jwt.jwtcode.model.User;
import org.springframework.stereotype.Service;

/**
 * @author Xu dong  ren
 * @date 2021/3/15
 */

public interface UserService {

    User Login(User user);


}
