package com.rosam.redisutil.service.impl;

import javax.annotation.Resource;

import com.rosam.redisutil.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


@Service
public class RedisServiceImpl implements RedisService {
    //@Resource（这个注解属于J2EE的），默认安照名称进行装配，名称可以通过name属性进行指定，
    //如果没有指定name属性，当注解写在字段上时，默认取字段名进行按照名称查找，如果注解写在setter方法上默认取属性名进行装配。
    //当找不到与名称匹配的bean时才按照类型进行装配。但是需要注意的是，如果name属性一旦指定，就只会按照名称进行装配。
    @Resource//匹配到bean中名为redisTemplate的bean即RedisConfig中的redisTemplate
    private RedisTemplate<String,Object> redisTemplate;
    @Resource//匹配到bean中名为redisTemplateStr的bean即RedisConfig中的redisTemplateStr
    private RedisTemplate<String,String> redisTemplateStr;
    /**
     *设置值(String,Object)类型
     */
    @Override
    public void set(String key, Object value) {
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);

    }
    /**
     *获取值(String,Object)类型
     */
    @Override
    public Object get(String key) {
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }
    /**
     * 获取值(String,String)类型
     */
    @Override
    public String getStr(String key) {
        System.out.println("获取值");
        ValueOperations<String, String> opsForValue = redisTemplateStr.opsForValue();
        return opsForValue.get(key);
    }
    /**
     * 设置值(String,String)类型
     */
    @Override
    public void setStr(String key, String value) {
        ValueOperations<String, String> opsForValue = redisTemplateStr.opsForValue();
        opsForValue.set(key, value);
    }

}
