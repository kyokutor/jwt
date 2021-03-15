package com.jwt.jwtcode.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author Xu dong  ren
 * @date 2021/3/15
 */
public class JWTUtils {

    private static final String SIGN= "!@#$%^&*123456789";


    /**
     * 生成Token
     */
    public static String getToken(Map<String,String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);
        //创建JWTBuilder
        JWTCreator.Builder builder = JWT.create();
        //设置payload
        map.forEach((k,v)->{
            builder.withClaim(k, v);
        });
        //设置过期时间和签名，生成token
        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SIGN));
        return token;
    }

    /**
     * 验证token
     */
    public static void TokenVerify(String token) {
        JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }

    /**
     * 获取token信息
     */
    public static DecodedJWT getTokenInfo(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        return verify;
    }



}
