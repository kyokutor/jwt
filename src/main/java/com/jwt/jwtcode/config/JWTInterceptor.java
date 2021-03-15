package com.jwt.jwtcode.config;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwt.jwtcode.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xu dong  ren
 * @date 2021/3/15
 * JWTInterceptor 拦截器
 */
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //获取请求头中的token
        String token = request.getHeader("token");
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            JWTUtils.TokenVerify(token);
            //放行请求
            return true;
        } catch (SignatureVerificationException e) {
            map.put("msg", "无效签名");
            e.printStackTrace();
        } catch (TokenExpiredException e) {
            map.put("msg", "token已过期");
            e.printStackTrace();
        } catch (AlgorithmMismatchException e) {
            map.put("msg", "算法不一致");
            e.printStackTrace();
        } catch (Exception e) {
            map.put("msg", "token无效");
            e.printStackTrace();
        }
        map.put("state",false);
        //使用jackson将map转为json
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(json);
        return false;
    }

}
