package com.jwt.jwtcode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class JwtCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtCodeApplication.class, args);
        System.out.println("hello world");
    }

}
