package com.sso.mapper;

import com.sso.entity.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangzx
 */
@Repository("userMapper")
public interface UserMapper {

    @Select("select * from sys_user where username = #{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property="roles",column = "id",javaType = List.class,
            many = @Many(select = "com.sso.mapper.RoleMapper.findByUid"))
    })
    SysUser findByUsername(String username);

}
