package com.jwt.jwtcode.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.jwt.jwtcode.model.User;
import com.jwt.jwtcode.server.UserService;
import com.jwt.jwtcode.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xu dong  ren
 * @date 2021/3/15
 */
@RestController
@Slf4j
public class UserlogController {


    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public Map<String,Object> login(User user){
        log.info("用户名：[{}]",user.getName());
        log.info("密码：[{}]",user.getPassword());
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            User userDB = userService.Login(user);
            Map<String,String> payload = new HashMap<String, String>();
            payload.put("id", userDB.getId());
            payload.put("name", userDB.getName());
            String token = JWTUtils.getToken(payload);
            map.put("state",true);
            map.put("msg","认证成功");
            map.put("token", token);
        } catch (Exception e) {
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    @PostMapping("/user/test")
    public Map<String,Object> test(HttpServletRequest request){

        String token = request.getHeader("token");
        DecodedJWT tokenInfo = JWTUtils.getTokenInfo(token);
        log.info("用户id：[{}]",tokenInfo.getClaim("id").asString());
        log.info("用户名：[{}]",tokenInfo.getClaim("name").asString());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("state", true);
        map.put("msg","请求成功");
        return map;
    }



}
