package com.beiyuan.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.beiyuan.common.result.Result;
import com.beiyuan.user.service.RootService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.params.SetParams;
import user.entity.Root;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@Api("Root")
@RestController
@RequestMapping("/catesharing/user/root")

public class RootController {

    @Autowired
    RootService rootService;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;


    @PostMapping("login")
    public Result login(@RequestBody Root root) {
        String username= root.getUsername();
        String password=root.getPassword();


        if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)){
            Map<String,Object> map=new HashMap<>();

            if(redisTemplate.opsForValue().get(username)!=null){
                map.put("token",redisTemplate.opsForValue().get(username));
                return Result.ok(map);
            }
            QueryWrapper<Root> wrapper=new QueryWrapper<>();
            wrapper.eq("username",username);
            wrapper.eq("password",password);

            if(rootService.count(wrapper)==1){
                String token= UUID.randomUUID().toString();
                token.replace("-","");
                redisTemplate.opsForValue().set(username,token,30, TimeUnit.MINUTES);
                map.put("token",token);
                return Result.ok(map);
            }
        }
        return Result.fail(null);
    }

//    @PostMapping("loginShiro")
//    public Result loginShiro(String username, String password){
//
//    }
    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("info")
    public Result info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","admin");
        map.put("avatar","https://i0.hdslb.com/bfs/article/d3364d6cffa7c5ba3e01feaac4bb178e350ede61.jpg@942w_942h_progressive.webp");
        return Result.ok(map);
    }
    /**
     * 退出
     * @return
     */
    @PostMapping("logout")
    public Result logout(){
        return Result.ok(null);
    }
}

