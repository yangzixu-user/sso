package com.sso.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author yangzx
 */
public class JsonUtils {

    public static final ObjectMapper mapper = new ObjectMapper();

    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);

    public static String toString(Object obj){
        if (obj==null){
            return null;
        }
        if (obj.getClass()==String.class){
            return (String) obj;
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
           log.error("json序列化出错：{}",obj,e);
           return null;
        }
    }


    public static <T> T toBean(String json,Class<T> tClass){
        try {
           return mapper.readValue(json,tClass);
        } catch (IOException e) {
            log.error("json解析出错：{}",json,e);
            return null;
        }
    }

    public static <A> A toList(String json,Class<A> aClass){
        try {
            return mapper.readValue(json,mapper.getTypeFactory().constructCollectionType(List.class,aClass));
        } catch (IOException e) {
            log.error("json解析出错：{}",json,e);
            return null;
        }
    }

    public static <K,V> Map<K,V> toMap(String json, Class<K> kClass,Class<V> vClass){
        try {
            return mapper.readValue(json,mapper.getTypeFactory().constructMapType(Map.class,kClass,vClass));
        } catch (IOException e) {
            log.error("json解析失败：{}",json,e);
            return null;
        }
    }

    public static <T> T nativeRead(String json , TypeReference<T> type){
        try {
            return mapper.readValue(json,type);
        } catch (IOException e) {
            log.error("json解析失败：{}",json,e);
            return null;
        }

    }
}
