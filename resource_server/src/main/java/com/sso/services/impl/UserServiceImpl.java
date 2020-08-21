package com.sso.services.impl;

import com.sso.entity.SysUser;
import com.sso.mapper.UserMapper;
import com.sso.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author yangzx
 */
@Service("userService")
public class UserServiceImpl implements UserService {

   private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userMapper.findByUsername(username);
        return sysUser;
    }


}
