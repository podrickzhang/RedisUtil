package com.rosam.redisutil.controller;

import com.rosam.redisutil.entity.User;
import com.rosam.redisutil.service.RedisService;
import com.rosam.redisutil.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/get")
    public @ResponseBody
    User getRedis(String key) {
        User user = (User) redisService.get(key);
        System.out.println(user.getPassword());
        return user;
    }

    /**
     * 向redis中添加实体对象
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/addUser")
    public @ResponseBody String addUser( @RequestParam String userName, @RequestParam String password) {
        System.out.println("进入添加方法");
        User user = new User();
        user.setPassword(password);
        user.setUserName(userName);
        System.out.println(user);
        redisService.set("userEntity", user);
        return "Saved success";
    }

    /**
     * 方法1：没有使用util的RedisUtil,实质两者是一样的
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value="/addStr",method = RequestMethod.GET,produces = "appliction/json;charset=utf-8")
    public @ResponseBody String addStr(@RequestParam String userName,@RequestParam String password) {
        redisService.setStr(userName, password);
        return "添加字符串成功!!";
    }

    /**
     * 方法2：使用了注入的RedisUtil
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value="/addStr1",method = RequestMethod.GET,produces = "appliction/json;charset=utf-8")
    public @ResponseBody String addStrByUtil(@RequestParam String userName,@RequestParam String password) {
        redisUtil.set(userName, password);
        return "添加字符串成功!!";
    }

    /**User
     * 获取redis中key的值
     * @param key
     * @return
     */
    @RequestMapping("/getStr")
    public @ResponseBody String getStr(@RequestParam String key) {
        return redisService.getStr(key);
    }

}
