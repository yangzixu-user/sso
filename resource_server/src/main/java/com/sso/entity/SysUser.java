package com.sso.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author yangzx
 */
@Data
public class SysUser implements UserDetails {

    private Integer id;
    private String userName;
    private String password;
    private Integer status;
    private List<SysRole> roles = new ArrayList<>();

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }
    @JsonIgnore
    @Override
    public String getUsername() {
        return userName;
    }

    /*下面4个方法是根据某些条件判断当前用户是否可用，可以直接设置为true*/
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() { //指示账户是否已过期
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() { //指示用户是否被锁定或解锁
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() { //指示用户的凭证（密码）是否已过期
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() { //指示用户是否被启用或禁用
        return status==1;
    }
}
