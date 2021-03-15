package com.jwt.jwtcode.userdao;

import com.jwt.jwtcode.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author Xu dong  ren
 * @date 2021/3/15
 */
@Mapper
public interface UserDaoMapper {

  User Login(User user);


}
