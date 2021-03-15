package com.jwt.jwtcode.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Xu dong  ren
 * @date 2021/3/15
 */
@Data
@Accessors(chain=true)
public class User {

    private String id;
    private String name;
    private String password;


}
