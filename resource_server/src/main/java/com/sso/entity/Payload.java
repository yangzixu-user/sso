package com.sso.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author yangzx
 * 为了方便后期获取token中的用户信息，将token中的载荷部分独立封装成一个单独的对象
 */
@Data
public class Payload<T> {
    private String id;
    private T userInfo;
    private Date expiration;

}
