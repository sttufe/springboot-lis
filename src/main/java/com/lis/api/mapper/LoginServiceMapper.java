package com.lis.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lis.api.entity.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginServiceMapper extends BaseMapper<Object> {

    @Select("select * from user_login where username=\'${username}\'")
    LoginUser getLoginUser(@Param("username") String  username);
}
