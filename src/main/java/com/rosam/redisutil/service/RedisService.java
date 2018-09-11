package com.rosam.redisutil.service;

public interface RedisService {


    public void set(String key, Object value);

    public Object get(String key);

    public String getStr(String key);

    public void setStr(String key, String value);
}
